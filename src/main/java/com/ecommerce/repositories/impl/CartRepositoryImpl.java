package com.ecommerce.repositories.impl;

import com.ecommerce.handlers.Connector;
import com.ecommerce.repositories.CartRepository;
import com.ecommerce.repositories.entites.CartEntity;
import com.ecommerce.repositories.entites.CartID;
import com.ecommerce.repositories.entites.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class CartRepositoryImpl extends RepositoryImpl<CartEntity, CartID> implements CartRepository {

    private static final CartRepositoryImpl INSTANCE = new CartRepositoryImpl();
    protected final EntityManager entityManager = Connector.getInstance().getEntityManager();

    private CartRepositoryImpl() {
    }

    public static CartRepositoryImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public List<CartEntity> getUserCart(int id) {

        Query query= entityManager.createQuery("select u.cart from "+ UserEntity.class.getSimpleName() +" u where u.id = "+id);
        List<CartEntity> cartEntities = query.getResultList();
        return cartEntities;
    }
}
