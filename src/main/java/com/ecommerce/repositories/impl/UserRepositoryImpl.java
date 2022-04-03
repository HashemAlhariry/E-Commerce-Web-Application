package com.ecommerce.repositories.impl;

import com.ecommerce.repositories.UserRepository;
import com.ecommerce.repositories.entites.UserEntity;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserRepositoryImpl extends RepositoryImpl<UserEntity, Long> implements UserRepository {
    private static final UserRepositoryImpl INSTANCE = new UserRepositoryImpl();

    private UserRepositoryImpl() {

    }

    public static UserRepositoryImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public List<UserEntity> getUserByEmail(String email) {
        String queryString2 = "select u from UserEntity u where u.email like :email";
        TypedQuery<UserEntity> query =entityManager.createQuery(queryString2,UserEntity.class).setParameter("email",  email);
        List<UserEntity> user = query.getResultList();
        return user;
    }
}
