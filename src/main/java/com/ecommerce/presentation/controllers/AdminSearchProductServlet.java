package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.services.ProductService;
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

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
@WebServlet(name = "admin-product-search", urlPatterns = {"/admin-product-search"})

public class AdminSearchProductServlet extends HttpServlet {
    ServletContext servletContext;
    ProductService productService;
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();
        productService= ProductServiceImpl.getInstance();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductEntity> searchedProducts=null;
        if (Integer.parseInt(request.getParameter("categoryId"))<=0 && request.getParameter("productPrice").equals(""))
        {
            searchedProducts=productService.findAll();

        }
        else if (Integer.parseInt(request.getParameter("categoryId"))<=0 && !request.getParameter("productPrice").equals(""))
        {
            searchedProducts = productService.findProductByPrice(BigDecimalParser.parse(request.getParameter("productPrice")));
        }
        else if (!request.getParameter("categoryId").equals(null) && request.getParameter("productPrice").equals(""))
        {
            searchedProducts = productService.findAllByCategoryId(Integer.parseInt(request.getParameter("categoryId")));
        }
        else
        {
            searchedProducts=productService.findProductByPriceAndCategoryId(BigDecimalParser.parse(request.getParameter("productPrice")),Integer.parseInt(request.getParameter("categoryId")));
//            searchedProducts = searchedProducts.stream().filter(product -> product.getPrice().compareTo(BigDecimalParser.parse(request.getParameter("productPrice"))) < 0).collect(Collectors.toList());

        }
        List<ProductBean>searchedProductsBeans = ProductMapper.INSTANCE.listEntitiesToBeans(searchedProducts);
        request.setAttribute("allProducts",searchedProductsBeans);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommonString.HOME_URL +"admin/pages/tables/products_view.jsp");
        requestDispatcher.forward(request, response);
    }
}
