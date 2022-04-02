package com.ecommerce.utils;

import com.ecommerce.presentation.beans.CartItemBean;
import com.ecommerce.presentation.beans.OrderDetailsBean;

import java.math.BigDecimal;
import java.util.ArrayList;
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

}
