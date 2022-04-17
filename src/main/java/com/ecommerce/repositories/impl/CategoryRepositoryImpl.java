package com.ecommerce.repositories.impl;

import com.ecommerce.handlers.EntityMangerUtil;
import com.ecommerce.repositories.CategoryRepository;
import com.ecommerce.repositories.entites.CategoryEntity;

public class CategoryRepositoryImpl  extends RepositoryImpl<CategoryEntity, Integer> implements CategoryRepository{
    public CategoryRepositoryImpl(String entityMangerId) {
        super(EntityMangerUtil.getInstance().getEntityManager(entityMangerId));

    }

}
