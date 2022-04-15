package com.ecommerce.services.impls;

import com.ecommerce.presentation.beans.CartItemBean;
import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.presentation.beans.ViewCartItem;
import com.ecommerce.repositories.CartRepository;
import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.entites.CartEntity;
import com.ecommerce.repositories.entites.CartID;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.repositories.entites.UserEntity;
import com.ecommerce.repositories.impl.CartRepositoryImpl;
import com.ecommerce.repositories.impl.ProductRepositoryImpl;
import com.ecommerce.repositories.impl.UserRepositoryImpl;
import com.ecommerce.services.CartService;
import com.ecommerce.utils.mappers.ProductMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService {
    private static final CartServiceImpl INSTANCE = new CartServiceImpl();
    private final ProductRepository productRepository = ProductRepositoryImpl.getInstance();
    private final CartRepository cartRepository = CartRepositoryImpl.getInstance();
    private final ProductMapper productMapper = ProductMapper.INSTANCE;
    public static CartServiceImpl getInstance(){
        return INSTANCE;
    }

    private CartServiceImpl(){

    }

    @Override
    public List<CartItemBean> getCartItemBeans(List<ViewCartItem> viewCartItems) {
        List<CartItemBean> cartItemBeans = new ArrayList<>();
        for (ViewCartItem viewCartItem : viewCartItems) {
            ProductEntity productEntity = productRepository.findById(viewCartItem.getId());
            ProductBean productBean = productMapper.productEntityToBean(productEntity);
            CartItemBean cartItemBean = new CartItemBean(productBean , viewCartItem.getQuantity());
            cartItemBeans.add(cartItemBean);
        }
        return cartItemBeans;
    }

    @Override
    public List<CartItemBean> getUserCartFromDataBase(int userId) {

          // get all cart records for specific user
          List<CartEntity> cartEntities = cartRepository.getUserCart(userId);

          //cart item beans to be returned to merge with cart item saved in database
          List<CartItemBean> cartItemBeans = new ArrayList<>();

        for (CartEntity cartEntity:cartEntities) {
            // get product
            // create cart item bean
            ProductEntity productEntity = productRepository.findById(cartEntity.getProduct().getId());
            ProductBean productBean = productMapper.productEntityToBean(productEntity);
            CartItemBean cartItemBean = new CartItemBean(productBean , cartEntity.getQuantity());
            cartItemBeans.add(cartItemBean);
        }

          // get all cart items bean
        return cartItemBeans;
    }

    @Override
    public List<CartEntity> getCartEntitiesFromJson(String cartJson , int userId) throws JsonProcessingException {
        List<CartEntity> cartEntities = new ArrayList<>();
        ObjectMapper jacksonMapper = new ObjectMapper();
        List<ViewCartItem> viewCartItems = jacksonMapper.readValue(cartJson, new TypeReference<List<ViewCartItem>>() {});
        System.out.println(viewCartItems);
        if (viewCartItems.size() > 0) {
            cartEntities.addAll(getCartEntitiesFromViewCartItems(viewCartItems, userId));
            System.out.println(cartEntities);
        }
        return cartEntities;
    }

    private List<CartEntity> getCartEntitiesFromViewCartItems(List<ViewCartItem> viewCartItems, int userId) {
        List<CartEntity> cartEntities = new ArrayList<>();
        UserEntity userEntity = UserRepositoryImpl.getInstance().findById(userId);
        for (ViewCartItem viewCartItem : viewCartItems) {
            ProductEntity productEntity = productRepository.findById(viewCartItem.getId());
            CartEntity cartEntity = new CartEntity(userEntity,productEntity,viewCartItem.getQuantity());
            cartEntity.setId(new CartID(productEntity.getId(),userId));
            cartEntities.add(cartEntity);
        }
        return cartEntities;

    }

    @Override
    public void saveUserCart(String cartJson, int userId) throws JsonProcessingException {
        List<CartEntity> cartEntitiesFromJson = getCartEntitiesFromJson(cartJson,userId);
        cartRepository.deleteUserCart(userId);
        cartEntitiesFromJson.forEach(cartRepository::save);
    }
}
