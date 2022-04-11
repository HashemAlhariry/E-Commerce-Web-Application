package com.ecommerce.repositories.impl;

import com.ecommerce.handlers.Connector;
import com.ecommerce.repositories.UserRepository;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.repositories.entites.UserEntity;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl extends RepositoryImpl<UserEntity, Integer> implements UserRepository {

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

    @Override
    public UserEntity findByEmail(String email) throws NoResultException {
        // update later to get user from DB Directly
//        entityManager.getTransaction().begin();
//        UserEntity userEntity = (UserEntity) entityManager.createNamedQuery("user.findByEmail")
//                .setParameter("email", email).getSingleResult();
//        entityManager.getTransaction().commit();
        ///////////////
        TypedQuery<UserEntity> query = entityManager.createNamedQuery("user.findByEmail", UserEntity.class);
        query.setParameter("email", email);
        System.out.println("query Result : "+ query.getSingleResult());
        if ( query.getSingleResult()!=null)
        {
            return query.getSingleResult();
        }
        return null;
    }



    @Override
    public UserEntity saveUser(UserEntity user) {
        //System.out.println("saveUser" + user.getEmail());
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        System.out.println("User saved " + user);
        return user;
    }



    @Override
    public UserEntity findById(int id) {
        entityManager.getTransaction().begin();
        List<UserEntity> resultList = (ArrayList<UserEntity>) entityManager.createNamedQuery("user.findById")
                .setParameter("id", id).getResultList();
        System.out.println(resultList);
        System.out.println("kkkkkkkkk");
        for (UserEntity user : resultList) {
            if (user.getId() == (id))
                return user;
        }
        return null;
    }


    @Override
    public UserEntity updateUser(UserEntity user) {
        int id =user.getId();
        System.out.println(id);
        UserEntity userid = findById(id);
        System.out.println(userid);
        entityManager.getTransaction().begin();
        UserEntity userUpdated = entityManager.merge(userid);
        entityManager.getTransaction().commit();
        System.out.println("User updated " + userUpdated);
        return userUpdated;

    }

}
