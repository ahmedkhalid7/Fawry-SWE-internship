package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();
    ProductRepository productRepository = new ProductRepository();

    @Override
    public void init() throws ServletException {
        super.init();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<form method='post'>");

        out.println("<input type='submit' name='action' value='List Products' />");
        out.println("<input type='submit' name='action' value='Add Product' />");

        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("List Products".equals(action)) {
            response.sendRedirect("/LetsGetFit/products/list");
        } else if ("Add Product".equals(action)) {
            response.sendRedirect("/LetsGetFit/products/addProduct");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
