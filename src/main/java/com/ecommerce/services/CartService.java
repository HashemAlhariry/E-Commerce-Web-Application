package com.ecommerce.services;

import com.ecommerce.presentation.beans.CartItemBean;
import com.ecommerce.presentation.beans.ViewCartItem;

import java.util.List;

public interface CartService {
    public  List<CartItemBean> getCartItemBeans(List<ViewCartItem> viewCartItems);
    public  List<CartItemBean> getUserCartFromDataBase(int userId);

}
