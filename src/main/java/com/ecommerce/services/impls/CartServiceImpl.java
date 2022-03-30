package com.ecommerce.services.impls;

import com.ecommerce.presentation.beans.CartItemBean;
import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.presentation.beans.ViewCartItem;
import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.repositories.impl.ProductRepositoryImpl;
import com.ecommerce.services.CartService;
import com.ecommerce.utils.mappers.ProductMapper;
import com.ecommerce.utils.mappers.ProductMapperImpl;

import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService {
    private static final CartServiceImpl INSTANCE = new CartServiceImpl();
    private final ProductRepository productRepository = ProductRepositoryImpl.getInstance();
    private final ProductMapper productMapper = new ProductMapperImpl();
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
}
