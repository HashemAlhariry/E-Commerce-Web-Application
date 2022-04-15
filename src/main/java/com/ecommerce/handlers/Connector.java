package com.ecommerce.handlers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connector {
    private static Connector INSTANCE;
    private static EntityManagerFactory entityManagerFactory;

    private Connector() {
        entityManagerFactory = Persistence.createEntityManagerFactory("amazonya");
    }

    public static synchronized Connector getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Connector();
        }
        return INSTANCE;
    }

    public void close() {
        if (entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
