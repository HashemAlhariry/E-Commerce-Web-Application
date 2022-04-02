package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.repositories.entites.CategoryEntity;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.repositories.entites.ProductState;
import com.ecommerce.services.CategoryServices;
import com.ecommerce.services.ProductService;
import com.ecommerce.services.impls.CategoryServicesImpl;
import com.ecommerce.services.impls.ProductServiceImpl;
import com.ecommerce.utils.CommonString;
import com.ecommerce.utils.mappers.ProductMapper;
import com.fasterxml.jackson.core.io.BigDecimalParser;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mapstruct.Mapper;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
@WebServlet(name = "admin-update-product", urlPatterns = {"/admin-update-product"})

public class AdminUpdateProductServlet extends HttpServlet {

    private ServletContext servletContext;
    ProductService productService;
    CategoryServices categoryServices;

    @Override
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();
        productService= ProductServiceImpl.getInstance();
        categoryServices= CategoryServicesImpl.getInstance();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductBean productBean = new ProductBean();

        Long productID = Long.parseLong(req.getParameter("productId"));
        ProductEntity productEntity = productService.findById(productID);
        int categoryId = Integer.parseInt(req.getParameter("productCategory"));
        CategoryEntity categoryEntity = categoryServices.findById(categoryId);
        productEntity.setCategory(categoryEntity);
        BigDecimal bigDecimalPrice = BigDecimalParser.parse(req.getParameter("productPrice"));
        System.out.println("bigdecimal"+bigDecimalPrice);
        productBean.setPrice(bigDecimalPrice);
        productEntity.setPrice(bigDecimalPrice);
        productEntity.setState(ProductState.valueOf(req.getParameter("productState")));
        productEntity.setName(req.getParameter("productName"));
        System.out.println("start Update");
        productService.update(productEntity);
        System.out.println("finish Update");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("admin-edit-product");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
