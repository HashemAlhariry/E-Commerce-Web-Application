package com.ecommerce.repositories.impl;

import com.ecommerce.handlers.EntityMangerUtil;
import com.ecommerce.repositories.UserRepository;
import com.ecommerce.repositories.entites.UserEntity;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserRepositoryImpl extends RepositoryImpl<UserEntity, Integer> implements UserRepository {

    public UserRepositoryImpl(String entityMangerId) {
        super(EntityMangerUtil.getInstance().getEntityManager(entityMangerId));

    }

    @Override
    public List<UserEntity> getUserByEmail(String email) {
        String queryString2 = "select u from UserEntity u where u.email like :email";
        TypedQuery<UserEntity> query = entityManager.createQuery(queryString2, UserEntity.class).setParameter("email",
                email);
        List<UserEntity> user = query.getResultList();
        return user;
    }

    @Override
    public UserEntity findByEmail(String email) {
        return (UserEntity) entityManager.createNamedQuery("user.findByEmail")
                .setParameter("email", email.trim()).getResultList().stream().findFirst().orElse(null);
    }


    @Override
    public UserEntity saveUser(UserEntity user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        return user;
    }


    @Override
    public UserEntity updateUser(UserEntity user) {
        int id = user.getId();
        UserEntity userid = findById(id);
        entityManager.getTransaction().begin();
        UserEntity userUpdated = entityManager.merge(userid);
        entityManager.getTransaction().commit();
        return userUpdated;

    }

}
