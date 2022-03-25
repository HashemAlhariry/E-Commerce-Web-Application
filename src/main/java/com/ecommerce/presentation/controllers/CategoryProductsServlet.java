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

@WebServlet(name = "category-product", urlPatterns = {"/categorized-product"})

public class CategoryProductsServlet extends HttpServlet {
    ServletContext servletContext;
    ProductService productService;

    @Override
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();
        productService= ProductServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameterValues("categoryId")!=null){
            int categoryId =  Integer.parseInt(req.getParameter("categoryId"));
            List<ProductEntity> categoryProducts = productService.findAllByCategoryId(categoryId);
            List<ProductBean>categorizedProductsBeans = ProductMapper.INSTANCE.listEntitiesToBeans(categoryProducts);
            req.setAttribute("categorizedProducts",categorizedProductsBeans);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL + "category-products.jsp");
            requestDispatcher.forward(req, resp);
        }
        //TODO if not entered id
        else{
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL + "404.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
