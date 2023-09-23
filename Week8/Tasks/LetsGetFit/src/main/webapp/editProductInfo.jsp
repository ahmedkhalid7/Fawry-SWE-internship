<%--
  Created by IntelliJ IDEA.
  User: ahmedkhaled
  Date: 10/09/2023
  Time: 1:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.Product" %>
<%@ page import="com.google.gson.Gson" %>

<!DOCTYPE html>
<html>
<head>
  <title>Edit Product Details</title>
</head>
<body>
<h1>Edit Product Details</h1>

<%
  String productJson = (String) request.getAttribute("productJson");
  Gson gson = new Gson();
  Product product = gson.fromJson(productJson, Product.class);
%>

<form action="/LetsGetFit/products/editProductInfo" method="POST">
  <input type="hidden" name="productId" value='<%= product.getId() %>'>
  <label for="productName">Product Name:</label>
  <input type="text" id="productName" name="productName" value="<%= product.getName() %>"><br><br>
  <label for="productPrice">Product Price:</label>
  <input type="text" id="productPrice" name="productPrice" value="<%= product.getPrice() %>"><br><br>
  <input type="submit" value="Save">
</form>
</body>
</html>