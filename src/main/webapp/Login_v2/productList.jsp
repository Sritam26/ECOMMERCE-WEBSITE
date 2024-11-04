<%@ page import="java.util.ArrayList" %>
<%@ page import="Products.Product" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
    <style>
        /* Basic styling */
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2 style="text-align:center;">Product List</h2>
    <table>
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Image</th>
            <th>Quantity</th>
            <th>Category</th>
        </tr>

        <%
            ArrayList<Product> productList = (ArrayList<Product>) session.getAttribute("productList");
            if (productList != null && !productList.isEmpty()) {
                for (Product product : productList) {
        %>
                    <tr>
                        <td><%= product.getProduct_id() %></td>
                        <td><%= product.getProduct_name() %></td>
                        <td><%= product.getPrice() %></td>
                        <td><%= product.getDescription() %></td>
                        <td>
                            <img src="<%= product.getPhoto_url() %>" alt="Product Image" width="100" height="100"/>
                        </td>
                        <td><%= product.getQuantity() %></td>
                        <td><%= product.getCategory() %></td>
                    </tr>
        <%
                }
            } else {
        %>
                <tr>
                    <td colspan="7">No products found.</td>
                </tr>
        <%
            }
        %>
    </table>
</body>
</html>