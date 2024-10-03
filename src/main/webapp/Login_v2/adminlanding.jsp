<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Admin Dashboard - E-Commerce</title>

    <!-- Font Icon (Optional) -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

    <!-- Google Fonts (Optional) -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap" rel="stylesheet">
    
    <!-- Main CSS -->
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f4f4f9;
            color: #333;
            overflow-x: hidden;
        }

        /* Navbar */
        .navbar {
            background-color: #1e1f29;
            padding: 20px;
            color: white;
            text-align: center;
        }

        .navbar h1 {
            font-size: 30px;
            font-weight: 600;
            margin: 0;
            text-transform: uppercase;
        }

        /* Container */
        .container {
            width: 90%;
            max-width: 1200px;
            margin: 40px auto;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
        }

        h2 {
            font-size: 28px;
            margin-bottom: 30px;
            color: #444;
        }

        /* Admin Options */
        .admin-options {
            display: flex;
            justify-content: space-around;
            margin-bottom: 40px;
        }

        .admin-options a {
            text-decoration: none;
            background-color: #5c67f2;
            color: white;
            padding: 15px 40px;
            border-radius: 50px;
            font-size: 18px;
            font-weight: 500;
            text-transform: uppercase;
            transition: 0.3s ease-in-out;
            box-shadow: 0 5px 15px rgba(92, 103, 242, 0.4);
        }

        .admin-options a:hover {
            background-color: #4046b0;
            box-shadow: 0 8px 20px rgba(92, 103, 242, 0.6);
        }

        /* Section Styling */
        .form-container {
            width: 100%;
            max-width: 800px;
            margin: 0 auto;
            background-color: #f9f9ff;
            border-radius: 10px;
            padding: 30px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.05);
            margin-bottom: 50px;
        }

        .form-container form {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 20px;
        }

        .form-container form input, .form-container form textarea {
            width: 100%;
            padding: 12px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 8px;
            outline: none;
            transition: border-color 0.3s ease-in-out;
        }

        .form-container form input:focus, .form-container form textarea:focus {
            border-color: #5c67f2;
        }

        .form-container form button {
            grid-column: 1 / 3;
            padding: 15px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 50px;
            font-size: 18px;
            cursor: pointer;
            text-transform: uppercase;
            transition: background-color 0.3s ease-in-out;
            box-shadow: 0 5px 15px rgba(40, 167, 69, 0.4);
        }

        .form-container form button:hover {
            background-color: #218838;
            box-shadow: 0 8px 20px rgba(40, 167, 69, 0.6);
        }

        /* Responsive */
        @media screen and (max-width: 768px) {
            .form-container form {
                grid-template-columns: 1fr;
            }
        }

        /* View Products Table */
        .product-table {
            width: 100%;
            max-width: 1000px;
            margin: 0 auto;
            background-color: #fff;
            border-collapse: collapse;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.05);
        }

        .product-table th, .product-table td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        .product-table th {
            background-color: #5c67f2;
            color: white;
        }

        .product-table tr:hover {
            background-color: #f1f1f1;
        }

    </style>
</head>
<body>

    <!-- Admin Navbar -->
    <div class="navbar">
        <h1>Admin Dashboard</h1>
    </div>

    <div class="container">
        <!-- Admin Options -->
        <h2>Manage Your Products</h2>
        <div class="admin-options">
            <a href="#add-product"><i class="fas fa-plus"></i> Add Product</a>
            <a href="#delete-product"><i class="fas fa-trash-alt"></i> Delete Product</a>
            <a href="#view-products"><i class="fas fa-list"></i> View All Products</a>
        </div>

        <!-- Add Product Section -->
        <div id="add-product" class="form-container">
            <h2>Add New Product</h2>
            <form method="POST" action="addProduct" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="product-id">Product ID</label>
                    <input type="text" name="product-id" id="product-id" placeholder="Enter Product ID" required>
                </div>
                <div class="form-group">
                    <label for="product-name">Product Name</label>
                    <input type="text" name="product-name" id="product-name" placeholder="Enter Product Name" required>
                </div>
                <div class="form-group">
                    <label for="price">Price</label>
                    <input type="text" name="price" id="price" placeholder="Enter Product Price" required>
                </div>
                <div class="form-group">
                    <label for="product-description">Product Description</label>
                    <textarea name="product-description" id="product-description" rows="4" placeholder="Enter Product Description"></textarea>
                </div>
                <div class="form-group">
                    <label for="product-picture">Product Picture</label>
                    <input type="file" name="product-picture" id="product-picture" required>
                </div>
                <button type="submit">Add Product</button>
            </form>
        </div>

        <!-- Delete Product Section -->
        <div id="delete-product" class="form-container">
            <h2>Delete Product</h2>
            <form method="POST" action="deleteProduct">
                <div class="form-group">
                    <label for="delete-product-id">Product ID</label>
                    <input type="text" name="delete-product-id" id="delete-product-id" placeholder="Enter Product ID to Delete" required>
                </div>
                <button type="submit">Delete Product</button>
            </form>
        </div>

        <!-- View Products Section -->
        <div id="view-products" class="form-container">
            <h2>All Products</h2>
            <table class="product-table">
                <thead>
                    <tr>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>Description</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Example of product rows, dynamically rendered -->
                    <tr>
                        <td>001</td>
                        <td>Product A</td>
                        <td>$20</td>
                        <td>A sample product</td>
                    </tr>
                    <tr>
                        <td>002</td>
                        <td>Product B</td>
                        <td>$50</td>
                        <td>Another sample product</td>
                    </tr>
                    <!-- More products would go here -->
                </tbody>
            </table>
        </div>

    </div>

</body>
</html>
