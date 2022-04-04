package com.ecommerce.repositories.impl;

import com.ecommerce.handlers.Connector;
import com.ecommerce.repositories.UserRepository;
import com.ecommerce.repositories.entites.UserEntity;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl extends RepositoryImpl<UserEntity, Long> implements UserRepository {

    private static final UserRepositoryImpl INSTANCE = new UserRepositoryImpl();
    protected final EntityManager entityManager = Connector.getInstance().getEntityManager();

    private UserRepositoryImpl() {

    }

    public static UserRepositoryImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public List<UserEntity> getUserByEmail(String email) {
        String queryString2 = "select u from UserEntity u where u.email like :email";
        TypedQuery<UserEntity> query = entityManager.createQuery(queryString2, UserEntity.class).setParameter("email",
                email);
        List<UserEntity> user = query.getResultList();
        return user;
    }

    public UserEntity findByEmail(String email) throws NoResultException {
        // update later to get user from DB Directly
        entityManager.getTransaction().begin();
        List<UserEntity> resultList = (ArrayList<UserEntity>) entityManager.createNamedQuery("user.findByEmail")
                .setParameter("email", email).getResultList();

        for (UserEntity user : resultList) {
            if (user.getEmail().equals(email))
                return user;
        }
        return null;
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        // System.out.println("saveUser" + user.getEmail());
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("User saved " + user);
        return user;
    }

}
