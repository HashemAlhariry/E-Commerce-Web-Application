package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.OrderHistoryBean;
import com.ecommerce.presentation.beans.UserBean;
import com.ecommerce.services.OrderService;
import com.ecommerce.services.impls.OrderServiceImpl;
import com.ecommerce.utils.CommonString;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "userorderhistory", urlPatterns = {"/userorderhistory"})
public class UserOrderHistoryServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession(false);
        UserBean userBean  = (UserBean) session.getAttribute("userBean");
        OrderService orderService=new OrderServiceImpl((String) request.getAttribute("reqId"));



        if(userBean!=null){
            //get all users order history

            List<OrderHistoryBean> orderHistoryBeans = orderService.getUserOrderHistory(userBean.getEmail());

            request.setAttribute("orderHistoryList",orderHistoryBeans);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommonString.HOME_URL + "user-order-history.jsp");
            requestDispatcher.forward(request, response);
        }else{
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommonString.HOME_URL + "home.jsp");
            requestDispatcher.forward(request, response);
        }

    };

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }


}
