package com.ecommerce.presentation.controllers;


import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.services.ProductService;
import com.ecommerce.services.impls.ProductServiceImpl;
import com.ecommerce.utils.CommonString;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "wishlist", urlPatterns = {"/wishlist"})
public class WishListPageServlet extends HttpServlet {

    public void init(ServletConfig config) {

    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommonString.HOME_URL + "wishlist-testing.jsp");
        requestDispatcher.forward(request, response);

    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ProductService productService = new ProductServiceImpl((String) request.getAttribute("reqId"));
        String jsonString = request.getParameter("wishlist");
        Type listType = new TypeToken<ArrayList<Long>>() {
        }.getType();
        List<Long> wishListProductsIds = new Gson().fromJson(jsonString, listType);
        System.out.println(wishListProductsIds.size());
        List<ProductBean> wishListProductBeans = productService.getAllProductBeans(wishListProductsIds);

        request.setAttribute("wishlistBeans", wishListProductBeans);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommonString.HOME_URL + "wishlist.jsp");
        requestDispatcher.forward(request, response);
    }

}


