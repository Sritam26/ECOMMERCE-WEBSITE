package Products;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

@WebServlet("/view")
public class Viewproduct extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ecommerce_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "s1r2i3t4a5m";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> productList = new ArrayList<>();
        
        // Database connection and retrieval logic
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String sql = "SELECT * FROM products";
                try (PreparedStatement statement = connection.prepareStatement(sql);
                     ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Product product = new Product();
                        product.setProduct_id(resultSet.getString("Product_id")); // Ensure the column name matches exactly
                        product.setProduct_name(resultSet.getString("Product_name"));
                        product.setPrice(resultSet.getDouble("Price"));
                        product.setDescription(resultSet.getString("Description"));
                        product.setPhoto_url(resultSet.getString("Photo_url")); // Ensure the column name matches exactly
                        product.setQuantity(resultSet.getInt("Quantity"));
                        product.setCategory(resultSet.getString("Category"));
                        productList.add(product);
                    }
                    System.out.println("Products retrieved: " + productList.size()); // Debug output
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.getWriter().println("MySQL JDBC Driver not found.");
            return;
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database error: " + e.getMessage());
            return;
        }

        // Store the product list in the session
        HttpSession session = request.getSession();
        session.setAttribute("productList", productList);

        // Redirect to the productList.jsp page using the context path
        response.sendRedirect(request.getContextPath() + "/productList.jsp");
    }
    

}