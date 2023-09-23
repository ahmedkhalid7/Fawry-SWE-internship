<%--
  Created by IntelliJ IDEA.
  User: ahmedkhaled
  Date: 09/09/2023
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="java.util.List" %>
<%@ page import="com.example.Product" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.google.gson.reflect.TypeToken" %>

<%
    String productsJson = (String) request.getAttribute("productsJson");
    Gson gson = new Gson();
    List<Product> products = gson.fromJson(productsJson, new TypeToken<List<Product>>(){}.getType());
%>

<!DOCTYPE html>
<html>
<head>
    <title>Product Grid</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        h1 {
            color: #333;
            text-align: center;
        }

        .product-grid {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            grid-gap: 10px;
            margin: 20px;
        }

        .product-card {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
            background-color: #fff;
            color: #333;
        }

        .product-actions {
            margin-top: 10px;
        }

        .product-actions button {
            margin-right: 10px;
        }
    </style>
</head>
<body>
<h1>List of Products</h1>

<div class="product-grid">
    <% for (Product product : products) { %>
    <div class="product-card">
        <p>Name: <%= product.getName() %></p>
        <p>Price: <%= product.getPrice() %></p>
        <div class="product-actions">
            <button onclick="location.href='/LetsGetFit/products/editProductInfo?id=<%= product.getId() %>'">Edit</button>
            <button onclick="location.href='/LetsGetFit/products/delete?id=<%= product.getId() %>'">Delete</button>
        </div>
    </div>
    <% } %>
</div>
</body>
</html>

