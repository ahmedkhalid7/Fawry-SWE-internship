package com.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/products/addProduct")
public class AddProductServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }

    ProductRepository productRepository = new ProductRepository();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/addProduct.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");

        Product product = new Product();
        product.setName(name);
        product.setPrice(Double.parseDouble(price));

        productRepository.addProduct(product);
        response.sendRedirect("/LetsGetFit/products");
    }

    @Override
    public void destroy() {
    }
}
