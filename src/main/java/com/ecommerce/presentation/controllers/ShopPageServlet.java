package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.services.ProductService;
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

@WebServlet(name = "shop",urlPatterns = {"/shop"})
public class ShopPageServlet extends HttpServlet {
    ServletContext servletContext;
    ProductService productService;
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();
        productService=(ProductService) servletContext.getAttribute("productService");
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductEntity> allProducts = productService.findAll();
        List<ProductBean> allProductsBeans = ProductMapper.INSTANCE.listEntitiesToBeans(allProducts);
        request.setAttribute("allProducts",allProductsBeans);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommonString.HOME_URL + "shop.jsp");
        requestDispatcher.forward(request, response);
    }
}
