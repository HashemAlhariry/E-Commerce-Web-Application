package com.ecommerce.handlers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connector {
    private static Connector INSTANCE;
    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;

    private Connector() {
        entityManagerFactory = Persistence.createEntityManagerFactory("amazonya");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static synchronized Connector getInstance() {
        if(INSTANCE==null){
            INSTANCE=new Connector();
        }
        return INSTANCE;
    }

    public void close() {
        if (entityManager.isOpen()) {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
