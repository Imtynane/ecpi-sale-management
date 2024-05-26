package com.sale.ecpisalemanagement.servlet;

import com.sale.ecpisalemanagement.model.Category;
import com.sale.ecpisalemanagement.model.Products;
import com.sale.ecpisalemanagement.sevices.CategoryService;
import com.sale.ecpisalemanagement.sevices.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "productServlet", urlPatterns = {"/products","/products/create","/products/update","/products/delete"})
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String route =req.getServletPath();

        if(route.equals("/products")){
            req.setAttribute("product", ProductService.all());
            req.getServletContext().getRequestDispatcher("/products/index.jsp").forward(req, resp);
        }
        else if(route.equals("/products/create")){
            req.getServletContext().getRequestDispatcher("/products/create.jsp").forward(req, resp);
        }
        else if(route.equals("/products/update")){
            req.setAttribute("products",ProductService.get(Integer.parseInt(req.getParameter("id"))));
            req.getServletContext().getRequestDispatcher("/products/update.jsp").forward(req, resp);
        }
        else if(route.equals("/products/delete")){
            ProductService.delete(Integer.parseInt(req.getParameter("id")));
            req.getServletContext().getRequestDispatcher("/products/index.jsp").forward(req, resp);
        }
        else {
            req.setAttribute("product",ProductService.all());
            req.getServletContext().getRequestDispatcher("/products/index.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String route =req.getServletPath();

        if(route.equals("/products/create")){
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            double price = Integer.parseInt(req.getParameter("price"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            Products products = new Products(name, description, price, quantity);
            ProductService.create(products);
            req.getServletContext().getRequestDispatcher("/products/create.jsp").forward(req, resp);
        }
        else if(route.equals("/products/update")){
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            double price = Integer.parseInt(req.getParameter("price"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            Products products = new Products(id, name, description, price, quantity);
            ProductService.update(products);
            req.getServletContext().getRequestDispatcher("/products/update.jsp").forward(req, resp);
        }
        else {
            req.setAttribute("product",ProductService.all());
            req.getServletContext().getRequestDispatcher("/products/index.jsp").forward(req, resp);
        }
    }
}
