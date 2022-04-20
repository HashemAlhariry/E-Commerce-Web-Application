
package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.CartItemBean;
import com.ecommerce.presentation.beans.OrderBean;
import com.ecommerce.presentation.beans.OrderDetailsBean;
import com.ecommerce.presentation.beans.ViewCartItem;
import com.ecommerce.repositories.entites.OrderState;
import com.ecommerce.services.CartService;
import com.ecommerce.services.OrderService;
import com.ecommerce.services.impls.CartServiceImpl;
import com.ecommerce.services.impls.OrderServiceImpl;
import com.ecommerce.utils.CommonString;
import com.ecommerce.utils.Util;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "order-completion", urlPatterns = { "/order-completion" })
public class OrderCompletionServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("home");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean orderAddedToDB = false;
        CartService cartService = new CartServiceImpl((String) request.getAttribute("reqId"));
        OrderService orderService = new OrderServiceImpl((String) request.getAttribute("reqId"));

        // update here to get user id from logged in user
        int userId = -1;

        // maybe used for admin statistics or sending vouchers to users
        String email = request.getParameter("userEmail");
        String address = request.getParameter("userAddress");
        String phoneNumber = request.getParameter("phoneNumber");
        String jsonString = request.getParameter("cart");
        String paymentMethod = request.getParameter("paymentMethod");
        HttpSession session = request.getSession();

        if (jsonString != null) {

            ObjectMapper jacksonMapper = new ObjectMapper();
            List<ViewCartItem> viewCartItems = jacksonMapper.readValue(jsonString,
                    new TypeReference<List<ViewCartItem>>() {
                    });
            List<CartItemBean> cartItemBeans;
            // to remove product with quantity 0
            List<CartItemBean> cartItemBeansUpdated = new ArrayList<>();

            if (viewCartItems.size() > 0) {

                cartItemBeans = cartService.getCartItemBeans(viewCartItems);

                // remove products cart bean , quantity = 0
                for (CartItemBean cartItemBean : cartItemBeans) {
                    if (cartItemBean.getProductBean().getQuantity() != 0) {
                        cartItemBeansUpdated.add(cartItemBean);
                    }
                }

                BigDecimal total = Util.getTotalPrice(cartItemBeans);
                OrderBean orderBean = new OrderBean(address, new Date(), phoneNumber, OrderState.PENDING, total, email);
                List<OrderDetailsBean> orderDetailsBeanList = Util.getOrderDetailsBeans(cartItemBeansUpdated, userId);

                orderAddedToDB = orderService.submitOrder(orderBean, orderDetailsBeanList, email);

                // order successfully added to DB send client to order successfully page
                if (orderAddedToDB) {

                    session.setAttribute("userEmail", email);
                    session.setAttribute("total", total.intValue() * 100);
                    session.setAttribute("mobileNumber", phoneNumber);
                    session.setAttribute("userAddress",address);

                    RequestDispatcher requestDispatcher = request
                            .getRequestDispatcher(CommonString.HOME_URL + "stripe-payment.jsp");
                    requestDispatcher.forward(request, response);

                } else {

                    // return user to cart with error message
                    // update later
                    RequestDispatcher requestDispatcher = request
                            .getRequestDispatcher(CommonString.HOME_URL + "cart.jsp");
                    requestDispatcher.forward(request, response);

                }

            }

        }
    }

}
