package Products;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/addproduct")
@MultipartConfig (
    fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
    maxFileSize = 1024 * 1024 * 10,      // 10 MB
    maxRequestSize = 1024 * 1024 * 15    // 15 MB
)// Enables file uploads
public class Addproduct extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ecommerce_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "s1r2i3t4a5m";

    // File upload directory
    private static final String UPLOAD_DIR = "uploads"; // Define a relative directory

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Validate inputs before processing
        String productId = request.getParameter("product_id");
        String productName = request.getParameter("product_name");
        String description = request.getParameter("description");
        String priceStr = request.getParameter("price");
        String quantityStr = request.getParameter("quantity");
        String product_photo=request.getParameter("product-picture");
        String category = request.getParameter("category");

        

        // Database connection and insert logic
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String sql = "INSERT INTO products (product_id, product_name, description, price, quantity, photo_url,category) VALUES (?, ?, ?, ?, ?, ?,?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, productId);
                    statement.setString(2, productName);
                    statement.setString(3, description);
                    statement.setString(4, priceStr);
                    statement.setString(5, quantityStr);
                    statement.setString(6, product_photo);
                    statement.setString(7, category);

                    statement.executeUpdate();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.getWriter().println("MySQL JDBC Driver not found.");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database error: " + e.getMessage());
        }

        // Redirect or display success message
        response.getWriter().println("Product added successfully!");
    }
}