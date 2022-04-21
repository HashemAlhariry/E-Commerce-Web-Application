package com.ecommerce.services.impls;

import com.ecommerce.presentation.beans.CartItemBean;
import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.presentation.beans.ViewCartItem;
import com.ecommerce.repositories.CartRepository;
import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.UserRepository;
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
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    public CartServiceImpl(String reqId) {
        productRepository = new ProductRepositoryImpl(reqId);
        cartRepository = new CartRepositoryImpl(reqId);
        userRepository = new UserRepositoryImpl(reqId);
    }

    @Override
    public List<CartItemBean> getCartItemBeans(List<ViewCartItem> viewCartItems) {
        List<CartItemBean> cartItemBeans = new ArrayList<>();
        for (ViewCartItem viewCartItem : viewCartItems) {
            ProductEntity productEntity = productRepository.findById(viewCartItem.getId());
            ProductBean productBean = productMapper.productEntityToBean(productEntity);
            int cartItemBeanQuantity = productEntity.getQuantity()<viewCartItem.getQuantity()? productEntity.getQuantity():viewCartItem.getQuantity();
            CartItemBean cartItemBean = new CartItemBean(productBean, cartItemBeanQuantity);
            cartItemBeans.add(cartItemBean);
        }
        return cartItemBeans;
    }
    @Override
    public List<ViewCartItem> getViewCartItemsFromCartItemBeans(List<CartItemBean> cartItemBeans){
        List<ViewCartItem> cartItems = new ArrayList<>();
        cartItemBeans.forEach(cartBean->cartItems.add(new ViewCartItem(cartBean.getProductBean().getId(),cartBean.getRequiredQuantity())));
        return cartItems;
    }

    @Override
    public List<CartItemBean> getUserCartFromDataBase(int userId) {

        // get all cart records for specific user
        List<CartEntity> cartEntities = cartRepository.getUserCart(userId);

        //cart item beans to be returned to merge with cart item saved in database
        List<CartItemBean> cartItemBeans = new ArrayList<>();

        for (CartEntity cartEntity : cartEntities) {
            // get product
            // create cart item bean
            ProductEntity productEntity = productRepository.findById(cartEntity.getProduct().getId());
            ProductBean productBean = productMapper.productEntityToBean(productEntity);
            CartItemBean cartItemBean = new CartItemBean(productBean, cartEntity.getQuantity());
            cartItemBeans.add(cartItemBean);
        }

        // get all cart items bean
        return cartItemBeans;
    }

    @Override
    public List<CartEntity> getCartEntitiesFromJson(String cartJson, int userId) throws JsonProcessingException {
        List<CartEntity> cartEntities = new ArrayList<>();
        ObjectMapper jacksonMapper = new ObjectMapper();
        List<ViewCartItem> viewCartItems= new ArrayList<>();
        if(!cartJson.isEmpty()){
            viewCartItems = jacksonMapper.readValue(cartJson, new TypeReference<List<ViewCartItem>>() {});
        }
        if (viewCartItems.size() > 0) {
            cartEntities.addAll(getCartEntitiesFromViewCartItems(viewCartItems, userId));
        }
        return cartEntities;
    }

    private List<CartEntity> getCartEntitiesFromViewCartItems(List<ViewCartItem> viewCartItems, int userId) {
        List<CartEntity> cartEntities = new ArrayList<>();
        UserEntity userEntity = userRepository.findById(userId);
        for (ViewCartItem viewCartItem : viewCartItems) {
            ProductEntity productEntity = productRepository.findById(viewCartItem.getId());
            CartEntity cartEntity = new CartEntity(userEntity, productEntity, viewCartItem.getQuantity());
            cartEntity.setId(new CartID(productEntity.getId(), userId));
            cartEntities.add(cartEntity);
        }
        return cartEntities;

    }

    @Override
    public void saveUserCart(String cartJson, int userId) throws JsonProcessingException {
        List<CartEntity> cartEntitiesFromJson = getCartEntitiesFromJson(cartJson, userId);
        //cartRepository.deleteUserCart(userId);
        List<CartEntity> cartEntitiesFromDataBase = cartRepository.getUserCartByUserId(userId);
        cartEntitiesFromDataBase.forEach(cartRepository::delete);
        cartEntitiesFromJson.forEach(cartRepository::update);
    }
}
