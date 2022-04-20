package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.presentation.beans.StatisticsBean;
import com.ecommerce.repositories.entites.OrderEntity;
import com.ecommerce.repositories.entites.OrderState;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.repositories.entites.ProductState;
import com.ecommerce.services.AdminDashoardServices;
import com.ecommerce.services.OrderService;
import com.ecommerce.services.ProductService;
import com.ecommerce.services.impls.AdminDashoardServicesImpl;
import com.ecommerce.services.impls.OrderServiceImpl;
import com.ecommerce.services.impls.ProductServiceImpl;
import com.ecommerce.utils.CommonString;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "admin-home", urlPatterns = {"/admin"})


public class AdminDashboardServlet extends HttpServlet {




    StatisticsBean statisticsBean = new StatisticsBean();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            AdminDashoardServices adminDashoardServices =new AdminDashoardServicesImpl((String) req.getAttribute("reqId"));
            ProductService productService = new ProductServiceImpl((String) req.getAttribute("reqId"));
            OrderService orderService = new OrderServiceImpl((String) req.getAttribute("reqId"));
            int outOfStock=0;
            int bestSeller=0;
            int newProduct=0;
            int orderPROCESSING=0;
            int orderARRIVED=0;
            int orderPENDING=0;
            int orderCANCELLED=0;

            RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL +"admin/index.jsp");
            int completedOrders = adminDashoardServices.getCompletedOrders();
            int notCompletedOrders = adminDashoardServices.getNotCompletedOrders();
            int waitingOrder = adminDashoardServices.getWaitingOrders();
            int statisticsUsers = adminDashoardServices.getStatisticsUsers();
            int allProducts = adminDashoardServices.getAllProducts();

            List<ProductEntity> productEntityList = productService.findAll();

            for (ProductEntity product: productEntityList) {
                if(product.getState().equals(ProductState.valueOf("NEW")))
                {
                    newProduct=newProduct+1;
                }
                else if (product.getState().equals(ProductState.valueOf("OUT_OF_STOCK")))
                {
                    outOfStock = outOfStock+1;
                }
                else if (product.getState().equals(ProductState.valueOf("BEST_SELLER")))
                {
                    bestSeller = bestSeller+1;
                }
            }

            List<OrderEntity> orderEntityList = orderService.findAll();
            for (OrderEntity order:orderEntityList) {
                if(order.getState().equals(OrderState.valueOf("NEW")))
                {
                    newProduct=newProduct+1;
                }
                else if (order.getState().equals(OrderState.valueOf("OUT_OF_STOCK")))
                {
                    outOfStock = outOfStock+1;
                }
                else if (order.getState().equals(OrderState.valueOf("BEST_SELLER")))
                {
                    bestSeller = bestSeller+1;
                }
                else if (order.getState().equals(OrderState.valueOf("BEST_SELLER")))
                {
                    bestSeller = bestSeller+1;
                }
            }

            statisticsBean.setCompletedOrders(completedOrders);
            statisticsBean.setNotCompletedOrders(notCompletedOrders);
            statisticsBean.setWaitingOrder(waitingOrder);
            statisticsBean.setAllProducts(allProducts);
            statisticsBean.setStatisticsUsers(statisticsUsers);


            req.setAttribute("outOfStock",outOfStock);
            req.setAttribute("newProduct",newProduct);
            req.setAttribute("bestSeller",bestSeller);
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


