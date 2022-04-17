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
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class SearchProductServlet extends HttpServlet {
    ServletContext servletContext;

    public void init(ServletConfig config) {
        servletContext = config.getServletContext();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl((String) request.getAttribute("reqId"));

        List<ProductEntity> searchedProducts = productService.findProductByName(request.getParameter("product-name"));
        List<ProductBean> searchedProductsBeans = ProductMapper.INSTANCE.listEntitiesToBeans(searchedProducts);
        request.setAttribute("productName", request.getParameter("product-name"));
        request.setAttribute("allProducts", searchedProductsBeans);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommonString.HOME_URL + "searched-products.jsp");
        requestDispatcher.forward(request, response);
    }
}
