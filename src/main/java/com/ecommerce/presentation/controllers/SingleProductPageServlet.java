package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.CategoryBean;
import com.ecommerce.presentation.beans.NewArrivalProductBean;
import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.repositories.entites.CategoryEntity;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.services.CategoryServices;
import com.ecommerce.services.ProductService;
import com.ecommerce.services.impls.CategoryServicesImpl;
import com.ecommerce.services.impls.ProductServiceImpl;
import com.ecommerce.utils.CommonString;
import com.ecommerce.utils.mappers.CategoryMapper;
import com.ecommerce.utils.mappers.NewArrivalProductMapper;
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

@WebServlet(name = "single-product-page",urlPatterns = {"/single-product-page"})

public class SingleProductPageServlet extends HttpServlet {
    ServletContext servletContext;
    ProductService productService;
    CategoryServices categoryService;

        public void init(ServletConfig config) {
            servletContext = config.getServletContext();
            productService= ProductServiceImpl.getInstance();
            categoryService= CategoryServicesImpl.getInstance();
        }


        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ProductEntity singleProduct = productService.findById(Long.parseLong(request.getParameter("productId")));
            ProductBean productBean = ProductMapper.INSTANCE.productEntityToBean(singleProduct);

            int cId = Integer.parseInt(String.valueOf(singleProduct.getCategory().getCategoryId()));
            CategoryEntity category = categoryService.findById(cId);
            CategoryBean categoryBean = CategoryMapper.INSTANCE.categoryEntityToBean(category);

            List<ProductEntity> relatedProducts = productService.relatedProducts(cId);
            List<ProductBean> relatedProductBeans = ProductMapper.INSTANCE.listEntitiesToBeans(relatedProducts);
            request.setAttribute("singleProduct",productBean);
            request.setAttribute("category",categoryBean);
            request.setAttribute("relatedProducts",relatedProductBeans);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommonString.HOME_URL + "product-centered.jsp");
            requestDispatcher.forward(request, response);

        }


    }
