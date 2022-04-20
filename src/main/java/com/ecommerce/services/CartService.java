package com.ecommerce.services;

import com.ecommerce.presentation.beans.CartItemBean;
import com.ecommerce.presentation.beans.ViewCartItem;
import com.ecommerce.repositories.entites.CartEntity;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface CartService {
    public List<CartItemBean> getCartItemBeans(List<ViewCartItem> viewCartItems);
    public List<CartItemBean> getUserCartFromDataBase(int userId);
    public List<CartEntity> getCartEntitiesFromJson(String cartJson, int userId) throws JsonProcessingException;
    public List<ViewCartItem> getViewCartItemsFromCartItemBeans(List<CartItemBean> cartItemBeans);
    void saveUserCart(String cartJson, int userId) throws JsonProcessingException;
}
