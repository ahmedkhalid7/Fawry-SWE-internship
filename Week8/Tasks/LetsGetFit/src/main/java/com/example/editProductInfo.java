package com.example;

import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/products/editProductInfo")
public class editProductInfo extends HttpServlet {
    ProductRepository productRepository = new ProductRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        Product product = productRepository.findProduct(productId);
        Gson gson = new Gson();
        String productJson = gson.toJson(product);
        request.setAttribute("productJson", productJson);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/editProductInfo.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("productId"));
        String name = request.getParameter("productName");
        String price = request.getParameter("productPrice");

        Product updatedProduct = new Product();
        updatedProduct.setId(id);
        updatedProduct.setName(name);
        updatedProduct.setPrice(Double.parseDouble(price));

        productRepository.updateProductInfo(updatedProduct);
        response.sendRedirect("/LetsGetFit/products/list");
    }
}
