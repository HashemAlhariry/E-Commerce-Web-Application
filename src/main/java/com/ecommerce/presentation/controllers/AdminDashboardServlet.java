package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.StatisticsBean;
import com.ecommerce.services.AdminDashoardServices;
import com.ecommerce.services.LoginServices;
import com.ecommerce.services.impls.AdminDashoardServicesImpl;
import com.ecommerce.services.impls.LoginServicesImpl;
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

//    private final AdminDashoardServices adminDashoardServices = AdminDashoardServicesImpl.getInstance();


    StatisticsBean statisticsBean = new StatisticsBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL +"admin/index.jsp");

        AdminDashoardServices adminDashoardServices =new AdminDashoardServicesImpl((String) req.getAttribute("reqId"));
        int completedOrders = adminDashoardServices.getCompletedOrders();
        int notCompletedOrders = adminDashoardServices.getNotCompletedOrders();
        int waitingOrder = adminDashoardServices.getWaitingOrders();
        int statisticsUsers = adminDashoardServices.getStatisticsUsers();
        int allProducts = adminDashoardServices.getAllProducts();
        int newProduct = adminDashoardServices.getNewProducts();
//        int OutOfStockProduct = adminDashoardServices.getOutOfStockProduct();
//        int OnSaleProduct = adminDashoardServices.getOnSaleProduct();
        int ArchivedProduct = adminDashoardServices.getArchivedProduct();



        statisticsBean.setCompletedOrders(completedOrders);
        statisticsBean.setNotCompletedOrders(notCompletedOrders);
        statisticsBean.setWaitingOrder(waitingOrder);
        statisticsBean.setAllProducts(allProducts);
        statisticsBean.setStatisticsUsers(statisticsUsers);
        statisticsBean.setNewProduct(newProduct);
        statisticsBean.setArchivedProduct(ArchivedProduct);
//        statisticsBean.setOnSaleProduct(OnSaleProduct);
//        statisticsBean.setOutOfStockProduct(OutOfStockProduct);



        System.out.println("bbbbbbbbbbbbbbb");
        System.out.println(statisticsBean);
        System.out.println("aaaaaaaaaaaaaa");


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
//            System.out.println("bbbbbbbbbbbbbbb");
//            System.out.println(statisticsBean);
//            System.out.println("aaaaaaaaaaaaaa");
//
//
//            req.setAttribute("statisticsBean",statisticsBean);

    }
}


