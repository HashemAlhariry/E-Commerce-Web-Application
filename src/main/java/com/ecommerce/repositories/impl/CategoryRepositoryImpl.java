package com.ecommerce.repositories.impl;

import com.ecommerce.repositories.CategoryRepository;
import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.entites.CategoryEntity;
import com.ecommerce.repositories.entites.ProductEntity;

public class CategoryRepositoryImpl  extends RepositoryImpl<CategoryEntity, Integer> implements CategoryRepository{
    private static final CategoryRepositoryImpl INSTANCE = new CategoryRepositoryImpl();

    private CategoryRepositoryImpl() {

    }

    public static CategoryRepositoryImpl getInstance() {
        return INSTANCE;
    }

}
