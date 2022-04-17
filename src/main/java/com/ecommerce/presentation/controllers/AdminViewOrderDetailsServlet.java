package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.AdminOrderDetailsBean;
import com.ecommerce.repositories.entites.OrderDetailsEntity;
import com.ecommerce.services.OrderDetailsService;
import com.ecommerce.services.impls.OrderDetailsServiceImpl;
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

@WebServlet(name = "admin-order-detail-view", urlPatterns = {"/admin-order-detail-view"})

public class AdminViewOrderDetailsServlet extends HttpServlet {

    private ServletContext servletContext;


    @Override
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDetailsService orderDetailsService = new OrderDetailsServiceImpl((String) req.getAttribute("reqId"));
        List<OrderDetailsEntity> orderDetailsEntity = orderDetailsService.findAllById(Integer.parseInt(req.getParameter("orderId")));
        List<AdminOrderDetailsBean> orderDetailsBean = AdminOrderDetailsMapper.INSTANCE.listEntitiesToBeans(orderDetailsEntity);
        BigDecimal totalPrice = orderDetailsEntity.get(0).getOrder().getTotalPrice();
        req.setAttribute("orderDetails", orderDetailsBean);
        req.setAttribute("totalPrice", totalPrice);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL + "admin/pages/samples/order_detail_view.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
