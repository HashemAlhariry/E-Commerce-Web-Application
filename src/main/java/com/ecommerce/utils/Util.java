package com.ecommerce.utils;

import com.ecommerce.presentation.beans.CartItemBean;
import com.ecommerce.presentation.beans.OrderDetailsBean;
import com.ecommerce.presentation.beans.ViewCartItem;
import com.ecommerce.services.CartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Util {


    public static final Double DeliveryFees=100.0;

    //getting total price for product depends on the available quantity in product
    public static BigDecimal getTotalPrice(List<CartItemBean> cartItemBeans) {
        BigDecimal totalPriceNumber=BigDecimal.ZERO;
        for (CartItemBean cartItem: cartItemBeans) {
            if(cartItem.getRequiredQuantity()<=cartItem.getProductBean().getQuantity()){
                totalPriceNumber=totalPriceNumber.add( cartItem.getProductBean().getPrice().multiply(BigDecimal.valueOf(cartItem.getRequiredQuantity())) );
            }else{
                totalPriceNumber=totalPriceNumber.add( cartItem.getProductBean().getPrice().multiply(BigDecimal.valueOf(cartItem.getProductBean().getQuantity())) );
            }
        }
        return totalPriceNumber;
    }


    //get from cart items beans order details bean to be used in submitting order
    public static List<OrderDetailsBean> getOrderDetailsBeans(List<CartItemBean> cartItemBeans, int userId){
        List<OrderDetailsBean> orderDetailsBeanList = new ArrayList<>();
        for (CartItemBean cartItemBean: cartItemBeans) {
            int totalQuantity;
            if(cartItemBean.getRequiredQuantity()<=cartItemBean.getProductBean().getQuantity()){
                totalQuantity=cartItemBean.getRequiredQuantity();
            }else{
                totalQuantity=cartItemBean.getProductBean().getQuantity();
            }
            OrderDetailsBean orderDetailsBean=new OrderDetailsBean(
                    cartItemBean.getProductBean(),
                    userId,
                    cartItemBean.getProductBean().getPrice(),
                    totalQuantity);
            orderDetailsBeanList.add(orderDetailsBean);
        }
        return orderDetailsBeanList;
    }

    // encode string base 64 encoder
    public static String encodeString(String inputString){
        return Base64.getEncoder().encodeToString(inputString.getBytes());
    }

    // decode string base 64 decoder
    public static  String decodeString(String outputString){
        byte[] decodedBytes = Base64.getDecoder().decode(outputString);
        return new String(decodedBytes);
    }

    //parse Json from local storage to get list of cart item beans
    public static List<CartItemBean> parseCartJsonToCartItemBeans(String jsonString, CartService cartService) throws JsonProcessingException {
        if(jsonString!=null) {
            if(!jsonString.isEmpty()){
                ObjectMapper jacksonMapper = new ObjectMapper();
                List<ViewCartItem> viewCartItems = jacksonMapper.readValue(jsonString, new TypeReference<List<ViewCartItem>>() {});
                System.out.println(viewCartItems);
                List<CartItemBean> cartItemBeans = new ArrayList<>();
                if (viewCartItems.size() > 0) {
                    cartItemBeans = cartService.getCartItemBeans(viewCartItems);
                    System.out.println(cartItemBeans);
                }
                return cartItemBeans;
            }
        }
        return new ArrayList<>();
    }

}


