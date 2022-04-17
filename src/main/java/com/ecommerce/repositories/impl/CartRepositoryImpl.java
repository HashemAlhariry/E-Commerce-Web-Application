package com.ecommerce.repositories.impl;

import com.ecommerce.handlers.EntityMangerUtil;
import com.ecommerce.repositories.CartRepository;
import com.ecommerce.repositories.entites.CartEntity;
import com.ecommerce.repositories.entites.CartID;
import com.ecommerce.repositories.entites.UserEntity;
import jakarta.persistence.Query;

import java.util.List;

public class CartRepositoryImpl extends RepositoryImpl<CartEntity, CartID> implements CartRepository {

    public CartRepositoryImpl(String entityMangerId) {
        super(EntityMangerUtil.getInstance().getEntityManager(entityMangerId));

    }

    @Override
    public List<CartEntity> getUserCart(int id) {

        Query query = entityManager.createQuery("select u.cart from " + UserEntity.class.getSimpleName() + " u where u.id = " + id);
        List<CartEntity> cartEntities = query.getResultList();
        return cartEntities;
    }

    @Override
    public void deleteUserCart(int id) {
        Query query = entityManager.createQuery("delete  from " + CartEntity.class.getSimpleName() + " c where c.id.userId = " + id);
        entityManager.getTransaction().begin();
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public List<CartEntity> getUserCartByUserId(int userId) {
        Query query = entityManager.createQuery("select c from  "+CartEntity.class.getSimpleName()+" c where c.user.id = "+ userId);
        return query.getResultList();
    }
}
