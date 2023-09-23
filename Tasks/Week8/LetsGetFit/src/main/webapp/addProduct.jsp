<%--
  Created by IntelliJ IDEA.
  User: ahmedkhaled
  Date: 09/09/2023
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Add Product</title>
  <style>
    body {
      font-family: Arial, sans-serif;
    }
    form {
      width: 300px;
      margin: 0 auto;
    }
    label {
      display: block;
      margin: 10px 0;
    }
    input[type="text"], input[type="number"] {
      width: 100%;
      padding: 10px;
      box-sizing: border-box;
      font-size: 1.2em;
    }
    input[type="submit"] {
      width: 100%;
      padding: 10px;
      margin-top: 10px;
      font-size: 1.2em;
      color: white;
      background-color: #5cb85c;
      border: none;
    }
  </style>
</head>
<body>
<form action="addProduct" method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required>
  <label for="price">Price:</label>
  <input type="text" id="price" name="price" required>
  <input type="submit" value="Add Product">
</form>
</body>
</html>

