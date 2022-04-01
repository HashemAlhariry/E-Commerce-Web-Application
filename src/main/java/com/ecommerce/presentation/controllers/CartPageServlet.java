package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.CartItemBean;
import com.ecommerce.presentation.beans.ViewCartItem;
import com.ecommerce.services.CartService;
import com.ecommerce.services.impls.CartServiceImpl;
import com.ecommerce.utils.CommonString;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "cart",urlPatterns = {"/cart"})
public class CartPageServlet extends HttpServlet {

    public void init(ServletConfig config) {

    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommonString.HOME_URL + "cart-testing.jsp");
        requestDispatcher.forward(request, response);

    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CartService cartService = CartServiceImpl.getInstance();

        String jsonString = request.getParameter("cart");
        if(jsonString!=null){
        ObjectMapper jacksonMapper = new ObjectMapper();
        List<ViewCartItem> viewCartItems = jacksonMapper.readValue(jsonString, new TypeReference<List<ViewCartItem>>(){});
        System.out.println(viewCartItems.size());
        List<CartItemBean> cartItemBeans = new ArrayList<>();
        BigDecimal subtotal=BigDecimal.ZERO;
        if(viewCartItems.size()>0){
            cartItemBeans = cartService.getCartItemBeans(viewCartItems);
            System.out.println(cartItemBeans);

        }
        for (CartItemBean cartItem: cartItemBeans) {
            subtotal = cartItem.getProductBean().getPrice().add(subtotal);
        }

        request.setAttribute("cartItemBeans",cartItemBeans);
        request.setAttribute("subTotal",subtotal);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommonString.HOME_URL + "cart.jsp");
        requestDispatcher.forward(request, response);
    }

}
