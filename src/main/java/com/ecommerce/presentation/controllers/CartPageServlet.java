package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.CartItemBean;
import com.ecommerce.services.CartService;
import com.ecommerce.services.impls.CartServiceImpl;
import com.ecommerce.utils.CommonString;
import com.ecommerce.utils.Util;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "cart", urlPatterns = {"/cart"})
public class CartPageServlet extends HttpServlet {
    public void init(ServletConfig config) {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommonString.HOME_URL + "cart-testing.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartService cartService = new CartServiceImpl((String) request.getAttribute("reqId"));
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.

        BigDecimal subtotal = BigDecimal.ZERO;

        String jsonString = request.getParameter("cart");
        List<CartItemBean> cartItemBeans = Util.parseCartJsonToCartItemBeans(jsonString, cartService);
        checkProductsAvailability(cartItemBeans,request);

        for (CartItemBean cartItem : cartItemBeans) {
            subtotal = subtotal.add(cartItem.getProductBean().getPrice().multiply(new BigDecimal(cartItem.getRequiredQuantity())));
        }
        request.setAttribute("cartItemBeans", cartItemBeans);
        request.setAttribute("subTotal", subtotal);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommonString.HOME_URL + "cart.jsp");
        requestDispatcher.forward(request, response);
    }

    private void checkProductsAvailability(List<CartItemBean> cartItemBeans, HttpServletRequest request) {
        int originalProductsNumber = cartItemBeans.size();
        cartItemBeans.removeIf(cartItemBean -> cartItemBean.getRequiredQuantity()==0);
        if(originalProductsNumber> cartItemBeans.size()) request.setAttribute("errorMessage","Some Products have been removed according to the stock availability");
    }

}
