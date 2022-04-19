package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.AdminOrderDetailsBean;
import com.ecommerce.repositories.entites.OrderDetailsEntity;
import com.ecommerce.repositories.entites.OrderEntity;
import com.ecommerce.repositories.entites.OrderState;
import com.ecommerce.services.OrderDetailsService;
import com.ecommerce.services.OrderService;
import com.ecommerce.services.ProductService;
import com.ecommerce.services.impls.OrderDetailsServiceImpl;
import com.ecommerce.services.impls.OrderServiceImpl;
import com.ecommerce.services.impls.ProductServiceImpl;
import com.ecommerce.utils.CommonString;
import com.ecommerce.utils.mappers.AdminOrderDetailsMapper;
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

@WebServlet(name = "admin-update-order", urlPatterns = {"/admin-update-order"})

public class AdminUpdateOrder extends HttpServlet {

    private ServletContext servletContext;


    @Override
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService orderService = new OrderServiceImpl((String) req.getAttribute("reqId"));
        OrderEntity order = new OrderEntity();
        order.setId(Integer.parseInt(req.getParameter("orderId")));
        order.setState(OrderState.valueOf(req.getParameter("orderStatus")));
        orderService.update(order);
        resp.sendRedirect("admin-order-view");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
