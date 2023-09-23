package com.example;

import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/products/list")
public class ListProductsServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }
    ProductRepository productRepository = new ProductRepository();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productRepository.getAllProducts();
        Gson gson = new Gson();
        String productsJson = gson.toJson(products);
        request.setAttribute("productsJson", productsJson);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listProducts.jsp");
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
        response.sendRedirect("LetsGetFit/products/list");
    }

    @Override
    public void destroy() {
    }
}
