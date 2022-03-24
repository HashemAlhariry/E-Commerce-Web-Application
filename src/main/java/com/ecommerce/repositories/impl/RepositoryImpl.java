package com.ecommerce.repositories.impl;

import com.ecommerce.handlers.Connector;
import com.ecommerce.repositories.Repository;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class RepositoryImpl<T, I> implements Repository<T, I> {
    protected final EntityManager entityManager = Connector.getInstance().getEntityManager();
    private final  Class<T> clazz;
    protected RepositoryImpl(){
        clazz =(Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
    @Override
    public T save(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public boolean delete(T entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public T findById(I id) {
        return entityManager.find(clazz,id);
    }

    @Override
    public List<T> findAll() {
//        return (List<T>) entityManager.createQuery("from"+clazz.getName()).getResultList();
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public T update(T entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }
}
