package com.ecommerce.handlers;

import jakarta.persistence.EntityManager;

import java.util.HashMap;
import java.util.Map;

public class EntityMangerUtil {
    private Map<String, EntityManager> entityManagers = new HashMap<>();
    public static final EntityMangerUtil INSTANCE = new EntityMangerUtil();

    private EntityMangerUtil() {

    }

    public static EntityMangerUtil getInstance() {
        return INSTANCE;
    }

    public EntityManager getEntityManager(String id) {
        EntityManager entityManager = entityManagers.get(id);
        if (entityManager == null) {
            entityManager = Connector.getInstance().getEntityManager();
            entityManagers.put(id, entityManager);
        }
        return entityManager;
    }

    public void closeEntityManager(String id) {
        EntityManager entityManager = entityManagers.get(id);
        if (entityManager != null) {
            if (entityManager.isOpen())
                entityManager.close();
            entityManagers.remove(id);
        }
    }

    public void closeAll() {
        entityManagers.forEach((k, v) -> v.close());
        entityManagers.clear();
    }
}
