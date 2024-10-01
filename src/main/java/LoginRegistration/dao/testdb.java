package LoginRegistration.dao;
import java.sql.*;
public class testdb {
	 private static final String jdbcURL = "jdbc:mysql://localhost:3306/ecommerce_db";
	    private static final String jdbcUsername = "root";
	    private static final String jdbcPassword = "Amiya@2002";

	    public static void main(String[] args) {
	        try {
	            // Establish connection
	            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	            System.out.println("Connection established successfully.");

	            // Prepare SQL statement
	            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, "testuser");
	            preparedStatement.setString(2, "testuser@example.com");
	            preparedStatement.setString(3, "password123");

	            // Execute the statement
	            int rowsInserted = preparedStatement.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("A new user was inserted successfully!");
	            }

	            // Close connection
	            preparedStatement.close();
	            connection.close();
	        } catch (SQLException e) {
	            System.err.println("SQL Exception: " + e.getMessage());
	        }
	    }
}
