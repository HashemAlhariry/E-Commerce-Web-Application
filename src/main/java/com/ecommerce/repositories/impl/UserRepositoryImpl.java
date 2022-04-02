package com.ecommerce.repositories.impl;

import com.ecommerce.handlers.Connector;
import com.ecommerce.repositories.UserRepository;
import com.ecommerce.repositories.entites.Role;
import com.ecommerce.repositories.entites.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private static final UserRepositoryImpl INSTANCE = new UserRepositoryImpl();
    protected final EntityManager entityManager = Connector.getInstance().getEntityManager();

    public static UserRepositoryImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public UserEntity findByEmail(String email) throws NoResultException {
        entityManager.getTransaction().begin();
        List<UserEntity> resultList = (ArrayList<UserEntity>) entityManager.createNamedQuery("User.findByEmail").setParameter("email", email).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();

        for (UserEntity user : resultList) {
            if (user.getEmail().equals(email))
                return user;
        }
        return null;
    }



}
