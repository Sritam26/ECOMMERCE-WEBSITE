<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Landing Page</title>
    <link rel="stylesheet" href="Addproductpage.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
</head>
<body>
    <header>
        <h1>Welcome to Our E-Commerce Store</h1>
    </header>
    
    <div class="container">
        <h2>Featured Products</h2>
        <div class="product-list">
            <%
                // Fetch products from the database
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "s1r2i3t4a5m");
                    String query = "SELECT * FROM products where category='mensfootwear'";
                    PreparedStatement ps = conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    
                    while (rs.next()) {
                        String productName = rs.getString("product_name");
                        String description = rs.getString("description");
                        String photoUrl = rs.getString("photo_url");
                        double price = rs.getDouble("price");
                        int quantity = rs.getInt("quantity");
            %>
                        <div class="product-item">
                            <img src="<%= photoUrl %>" alt="Product Image" class="product-image" />
                            <h3 class="product-name"><%= productName %></h3>
                            <p class="product-description"><%= description %></p>
                            <p class="product-price">Price: $<%= price %></p>
                            <p class="product-quantity">Available: <%= quantity %></p>
                            <button class="add-to-cart">Add to Cart</button>
                        </div>
            <%
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
        </div>
    </div>

    <footer>
        <p>&copy; 2024 E-Commerce Store. All rights reserved.</p>
    </footer>
</body>
</html>
