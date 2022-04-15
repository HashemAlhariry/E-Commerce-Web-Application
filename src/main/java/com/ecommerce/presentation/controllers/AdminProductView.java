package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.services.ProductService;
import com.ecommerce.services.impls.ProductServiceImpl;
import com.ecommerce.utils.CommonString;
import com.ecommerce.utils.mappers.ProductMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "admin-product-view", urlPatterns = {"/admin-product"})

public class AdminProductView extends HttpServlet {

    private ServletContext servletContext;

    @Override
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl((String) req.getAttribute("reqId"));

        List<ProductEntity> allProducts = productService.findAll();
        System.out.println(allProducts);
        List<ProductBean> allProductsBeans = ProductMapper.INSTANCE.listEntitiesToBeans(allProducts);
        System.out.println(allProductsBeans);
        req.setAttribute("allProducts", allProductsBeans);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL + "admin/pages/tables/products_view.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
