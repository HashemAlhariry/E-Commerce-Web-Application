package com.ecommerce.presentation.controllers;

import com.ecommerce.services.ProductService;
import com.ecommerce.services.impls.ProductServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "admin-delete-product", urlPatterns = {"/admin-delete-product"})

public class AdminDeleteProductServlet extends HttpServlet {

    private ServletContext servletContext;


    @Override
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService=new ProductServiceImpl((String) req.getAttribute("reqId"));
        Long idNumber=Long.parseLong(req.getParameter("productId"));

        productService.delete(productService.findById(idNumber));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
