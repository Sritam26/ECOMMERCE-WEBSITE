package LoginRegistration.dao;

import java.sql.*;
import UserModel.Admin;

public class AdminDao {
    // Database credentials
    private String jdbcurl = "jdbc:mysql://localhost:3306/ecommerce_db";
    private String jdbcusername = "root";
    private String password = "s1r2i3t4a5m";
    
    // SQL queries
    private String INSERT_USER_SQL = "INSERT INTO admin (username, email, password) VALUES (?, ?, ?)";
    private String SELECT_USER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM admin WHERE email = ? AND password = ?";  // Changed to admin table

    // Method to establish database connection
    private Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Load MySQL JDBC Driver
            connection = DriverManager.getConnection(jdbcurl, jdbcusername, password);
            System.out.println("Connection established successfully.");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
            throw new SQLException("Unable to load JDBC Driver.", e);
        }
        return connection;
    }

    // Register a new admin user
    public void registerUser(Admin admin) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            
            // Set parameters
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, admin.getEmail());
            preparedStatement.setString(3, admin.getPassword());  // Plain text password (not secure)
            
            // Execute the insert query
            preparedStatement.executeUpdate();
            System.out.println("Admin user registered successfully.");
        } catch (SQLException e) {
            System.err.println("SQL error occurred during registration: " + e.getMessage());
            e.printStackTrace();  // Print stack trace for debugging
        }
    }

    // Login an admin user by validating email and password
    public Admin loginAdmin(String email, String password) {
        Admin admin = null;
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL_AND_PASSWORD)) {
            
            // Set parameters
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);  // Direct password comparison (not secure)
            
            // Execute the select query
            ResultSet rs = preparedStatement.executeQuery();
            
            // Check if a matching record is found
            if (rs.next()) {
                // Populate the Admin object with data from the database
                admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));  // Returning the password (not recommended)
            }
        } catch (SQLException e) {
            System.err.println("SQL error occurred during login: " + e.getMessage());
            e.printStackTrace();  // Print stack trace for debugging
        }
        
        return admin;  // Return admin object (null if no match found)
    }
}
