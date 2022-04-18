package com.ecommerce.repositories.impl;

import com.ecommerce.handlers.EntityMangerUtil;
import com.ecommerce.repositories.CodeRepo;
import com.ecommerce.repositories.entites.CodeEntity;

public class CodeRepoImpl extends RepositoryImpl<CodeEntity, Integer> implements CodeRepo {
    public CodeRepoImpl(String entityMangerId) {
        super(EntityMangerUtil.getInstance().getEntityManager(entityMangerId));

    }

    @Override
    public CodeEntity findByCode(String code) {
        return (CodeEntity) entityManager.createNamedQuery("findByCode")
                .setParameter("code", code).getResultList().stream().findFirst().orElse(null);
    }
}
