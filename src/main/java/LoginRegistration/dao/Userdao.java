package LoginRegistration.dao;

import java.sql.*;
import UserModel.User;

public class Userdao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/ecommerce_db";
    private String jdbcUsername = "root";
    private String jdbcPassword = "s1r2i3t4a5m";

    private static final String INSERT_USER_SQL = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
    private static final String SELECT_USER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM users WHERE email = ? AND password = ?";

    // Method to get database connection
    private Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("Connection established successfully.");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
            throw new SQLException("Unable to load JDBC Driver.", e);
        }
        return connection;
    }

    // Register user in the database
    public void registerUser(User user) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword()); // Storing the password directly
            preparedStatement.executeUpdate();
        }
    }

    // Login user by validating email and password
    public User loginUser(String email, String password) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL_AND_PASSWORD)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password); // Direct password comparison
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password")); // Returning the password (not recommended for production)
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log error details for debugging
        }
        return user;
    }
}
