package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.OrderBean;
import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.repositories.entites.OrderEntity;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.services.OrderService;
import com.ecommerce.services.ProductService;
import com.ecommerce.services.impls.OrderServiceImpl;
import com.ecommerce.services.impls.ProductServiceImpl;
import com.ecommerce.utils.CommonString;
import com.ecommerce.utils.mappers.OrderMapper;
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

public class AdminViewOrdersServlet extends HttpServlet {

    private ServletContext servletContext;
    OrderService orderService;

    @Override
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();
        orderService= OrderServiceImpl.getInstance();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OrderEntity> allOrders = orderService.findAll();
        System.out.println(allOrders);
        List<OrderBean> allProductsBeans = OrderMapper.INSTANCE.listEntitiesToBeans(allOrders);
        System.out.println(allProductsBeans);
        req.setAttribute("allProducts",allProductsBeans);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL +"admin/pages/tables/products_view.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
