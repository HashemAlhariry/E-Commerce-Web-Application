package com.ecommerce.repositories.impl;

import com.ecommerce.handlers.Connector;
import com.ecommerce.repositories.Repository;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class RepositoryImpl<T, I> implements Repository<T, I> {
    protected final EntityManager entityManager = Connector.getInstance().getEntityManager();

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
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public List<T> findAll() {
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
