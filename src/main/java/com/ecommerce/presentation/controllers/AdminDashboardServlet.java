package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.StatisticsBean;
import com.ecommerce.services.AdminDashoardServices;
import com.ecommerce.services.impls.AdminDashoardServicesImpl;
import com.ecommerce.utils.CommonString;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "admin-home", urlPatterns = {"/admin"})


public class AdminDashboardServlet extends HttpServlet {




    StatisticsBean statisticsBean = new StatisticsBean();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            AdminDashoardServices adminDashoardServices =new AdminDashoardServicesImpl((String) req.getAttribute("reqId"));
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL +"admin/index.jsp");
            int completedOrders = adminDashoardServices.getCompletedOrders();
            int notCompletedOrders = adminDashoardServices.getNotCompletedOrders();
            int waitingOrder = adminDashoardServices.getWaitingOrders();
            int statisticsUsers = adminDashoardServices.getStatisticsUsers();
            int allProducts = adminDashoardServices.getAllProducts();


            statisticsBean.setCompletedOrders(completedOrders);
            statisticsBean.setNotCompletedOrders(notCompletedOrders);
            statisticsBean.setWaitingOrder(waitingOrder);
            statisticsBean.setAllProducts(allProducts);
            statisticsBean.setStatisticsUsers(statisticsUsers);



            req.setAttribute("statisticsBean",statisticsBean);

            requestDispatcher.forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//            int completedOrders = adminDashoardServices.getCompletedOrders();
//            int notCompletedOrders = adminDashoardServices.getNotCompletedOrders();
//            int waitingOrder = adminDashoardServices.getWaitingOrders();
//            int statisticsUsers = adminDashoardServices.getStatisticsUsers();
//            int allProducts = adminDashoardServices.getAllProducts();
//
//
//            statisticsBean.setCompletedOrders(completedOrders);
//            statisticsBean.setNotCompletedOrders(notCompletedOrders);
//            statisticsBean.setWaitingOrder(waitingOrder);
//            statisticsBean.setAllProducts(allProducts);
//            statisticsBean.setStatisticsUsers(statisticsUsers);
//
//
//
//            req.setAttribute("statisticsBean",statisticsBean);

        }
}


