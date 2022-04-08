package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.OrderBean;
import com.ecommerce.presentation.beans.OrderDetailsBean;
import com.ecommerce.repositories.entites.OrderDetailsEntity;
import com.ecommerce.services.OrderDetailsService;
import com.ecommerce.services.OrderService;
import com.ecommerce.services.impls.OrderDetailsServiceImpl;
import com.ecommerce.services.impls.OrderServiceImpl;
import com.ecommerce.utils.CommonString;
import com.ecommerce.utils.mappers.OrderDetailsMapper;
import com.ecommerce.utils.mappers.OrderMapper;
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
    OrderService orderService;
    OrderDetailsService orderDetailsService;

    @Override
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();
        orderService= OrderServiceImpl.getInstance();
        orderDetailsService = OrderDetailsServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OrderDetailsEntity> orderDetailsEntity =  orderDetailsService.findAllById(Integer.parseInt(req.getParameter("orderId")));
        List<OrderDetailsBean> orderDetailsBean = OrderDetailsMapper.INSTANCE.listEntitiesToBeans(orderDetailsEntity);
        BigDecimal totalPrice=orderDetailsEntity.get(0).getOrder().getTotalPrice();
        req.setAttribute("orderDetails",orderDetailsEntity);
        req.setAttribute("totalPrice",totalPrice);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL +"admin/pages/samples/order_detail_view.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
