package com.ecommerce.repositories.impl;

import com.ecommerce.repositories.UserRepository;
import com.ecommerce.repositories.entites.UserEntity;

public class UserRepositoryImpl extends RepositoryImpl<UserEntity, Long> implements UserRepository {
    private static final UserRepositoryImpl INSTANCE = new UserRepositoryImpl();

    private UserRepositoryImpl() {

    }

    public static UserRepositoryImpl getInstance() {
        return INSTANCE;
    }
}
