package com.ecommerce.presentation.controllers;

import com.ecommerce.exceptions.IllegalInputException;
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

@WebServlet(name = "shop",urlPatterns = {"/shop"})
public class ShopPageServlet extends HttpServlet {
    ServletContext servletContext;
    ProductService productService;
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();
        productService= ProductServiceImpl.getInstance();
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductBean> allProductsBeans;
        String pageNumberAsString = request.getParameter("pageNumber");
        System.out.println("pageNumberAsString " +pageNumberAsString);
        if (pageNumberAsString == null){
            allProductsBeans = productService.getProductsOfPage(1);
        }
        else{
            int pageNumber = Integer.parseInt(pageNumberAsString.trim());
            System.out.println("pageNumber"+pageNumber);
            allProductsBeans = productService.getProductsOfPage(pageNumber);
        }
        int totalCount = productService.getAllProductsCount();
        int countOfProductsPerPage = 12;
        int numberOfPages = (int)Math.ceil((float)totalCount/countOfProductsPerPage);
        if(allProductsBeans != null){
            System.out.println(allProductsBeans);
            request.setAttribute("allProducts",allProductsBeans);
            request.setAttribute("totalCount",totalCount);
            request.setAttribute("numberOfPages", numberOfPages);
            request.setAttribute("currentPageProductsNumber", allProductsBeans.size());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommonString.HOME_URL + "shop.jsp");
            requestDispatcher.forward(request, response);
        }
        else{
            throw new IllegalInputException();
        }
    }
}
