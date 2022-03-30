package com.ecommerce.services;

import com.ecommerce.presentation.beans.CartItemBean;
import com.ecommerce.presentation.beans.ViewCartItem;

import java.util.List;

public interface CartService {
    public abstract List<CartItemBean> getCartItemBeans(List<ViewCartItem> viewCartItems);
}
