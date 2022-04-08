package com.ecommerce.presentation.controllers;

import com.ecommerce.services.ProductService;
import com.ecommerce.services.impls.ProductServiceImpl;
import com.ecommerce.utils.CommonString;
import jakarta.servlet.RequestDispatcher;
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
    ProductService productService;

    @Override
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();
        productService = ProductServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("delete id request param = "+req.getParameter("productId"));
        Long idNumber=Long.parseLong(req.getParameter("productId"));
        System.out.println("long number"+idNumber);

        productService.delete(productService.findById(idNumber));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}