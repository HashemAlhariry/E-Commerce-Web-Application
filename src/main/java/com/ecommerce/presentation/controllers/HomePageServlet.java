package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.NewArrivalProductBean;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.services.ProductService;
import com.ecommerce.services.impls.ProductServiceImpl;
import com.ecommerce.utils.CommonString;
import com.ecommerce.utils.mappers.NewArrivalProductMapper;
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

@WebServlet(name = "home", urlPatterns = {"", "/home"})
public class HomePageServlet extends HttpServlet {

    ServletContext servletContext;

    @Override
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl((String) req.getAttribute("reqId"));
        List<ProductEntity> newArrivals = productService.getLast10();
        List<NewArrivalProductBean> newArrivalsBeans = NewArrivalProductMapper.INSTANCE.listEntitiesToBeans(newArrivals);
        req.setAttribute("newArrivals", newArrivalsBeans);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL + "index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
