package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.OrderBean;
import com.ecommerce.repositories.entites.OrderEntity;
import com.ecommerce.services.OrderService;
import com.ecommerce.services.impls.OrderServiceImpl;
import com.ecommerce.utils.CommonString;
import com.ecommerce.utils.mappers.OrderMapper;
import com.ecommerce.utils.mappers.OrderMapperImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mapstruct.Mapper;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "admin-order-detail-view", urlPatterns = {"/admin-order-detail-view"})

public class AdminViewOrderDetailsServlet extends HttpServlet {

    private ServletContext servletContext;
    OrderService orderService;

    @Override
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();
        orderService= OrderServiceImpl.getInstance();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderEntity orderEntity = orderService.findById(Integer.parseInt(req.getParameter("orderId")));
        System.out.println(orderEntity.toString());
        OrderBean orderBean = OrderMapper.INSTANCE.orderEntityToBean(orderEntity);
        System.out.println(orderBean);
        req.setAttribute("order",orderBean);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL +"admin/pages/samples/order_detail_view.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
