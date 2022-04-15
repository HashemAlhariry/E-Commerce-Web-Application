package com.ecommerce.presentation.controllers;

import com.ecommerce.repositories.entites.CategoryEntity;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.repositories.entites.ProductState;
import com.ecommerce.services.CategoryServices;
import com.ecommerce.services.ProductService;
import com.ecommerce.services.impls.CategoryServicesImpl;
import com.ecommerce.services.impls.ProductServiceImpl;
import com.fasterxml.jackson.core.io.BigDecimalParser;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "admin-update-product", urlPatterns = {"/admin-update-product"})

public class AdminUpdateProductServlet extends HttpServlet {

    private ServletContext servletContext;


    @Override
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl((String) req.getAttribute("reqId"));
        CategoryServices categoryServices = new CategoryServicesImpl((String) req.getAttribute("reqId"));

        Long productID = Long.parseLong(req.getParameter("productId"));
        ProductEntity productEntity = productService.findById(productID);

        int categoryId = Integer.parseInt(req.getParameter("productCategory"));
        CategoryEntity categoryEntity = categoryServices.findById(categoryId);

        BigDecimal bigDecimalPrice = BigDecimalParser.parse(req.getParameter("productPrice"));

        productEntity.setCategory(categoryEntity);
        productEntity.setPrice(bigDecimalPrice);
        productEntity.setState(ProductState.valueOf(req.getParameter("productState")));
        productEntity.setName(req.getParameter("productName"));
        productEntity.setQuantity(Integer.parseInt(req.getParameter("productQuantity")));
        productEntity.setDescription(req.getParameter("productDescription"));

        productService.update(productEntity);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("admin-edit-product");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
