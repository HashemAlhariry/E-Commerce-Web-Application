package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.CartItemBean;
import com.ecommerce.presentation.beans.ViewCartItem;
import com.ecommerce.services.CartService;
import com.ecommerce.services.impls.CartServiceImpl;
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

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "order-details", urlPatterns = {"/order-details"})
public class OrderDetailsServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommonString.HOME_URL + "order-details-testing.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        CartService cartService = CartServiceImpl.getInstance();
        String jsonString = request.getParameter("cart");
        if(jsonString!=null) {

            ObjectMapper jacksonMapper = new ObjectMapper();
            List<ViewCartItem> viewCartItems = jacksonMapper.readValue(jsonString, new TypeReference<List<ViewCartItem>>(){});

            //availabilityProducts list for products that user ordered and below available in stock to be sent to inform user
            List<String> availabilityProducts= new ArrayList<>();

            List<CartItemBean> cartItemBeans = new ArrayList<>();
            BigDecimal subtotal=BigDecimal.ZERO;

            if(viewCartItems.size()>0){

                cartItemBeans = cartService.getCartItemBeans(viewCartItems);
                System.out.println(cartItemBeans);

            }

            //check if required quantity available or not
            for (CartItemBean cartItem: cartItemBeans) {
                if(cartItem.getRequiredQuantity()<=cartItem.getProductBean().getQuantity()){
                    subtotal=subtotal.add( cartItem.getProductBean().getPrice().multiply(BigDecimal.valueOf(cartItem.getRequiredQuantity())) );
                    availabilityProducts.add("Required quantity Product for " + cartItem.getProductBean().getName() + " are " + cartItem.getRequiredQuantity());
                }else{
                    subtotal=subtotal.add( cartItem.getProductBean().getPrice().multiply(BigDecimal.valueOf(cartItem.getProductBean().getQuantity())) );
                    availabilityProducts.add("Only available Product for " + cartItem.getProductBean().getName() + " are " + cartItem.getProductBean().getQuantity());
                }
            }

            System.out.println(subtotal);

            request.setAttribute("availabilityProducts",availabilityProducts);
            request.setAttribute("subTotal",subtotal);
            request.setAttribute("deliveryFees", Util.DeliveryFees);
            request.setAttribute("cartItems",cartItemBeans);
            request.setAttribute("total",subtotal.add(BigDecimal.valueOf(Util.DeliveryFees)));

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommonString.HOME_URL + "order-details.jsp");
            requestDispatcher.forward(request, response);

        }



    }

}
