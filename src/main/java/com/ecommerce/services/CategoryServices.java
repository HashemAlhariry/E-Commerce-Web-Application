package com.ecommerce.services;

import com.ecommerce.repositories.entites.CategoryEntity;
import com.ecommerce.repositories.entites.ProductEntity;

import java.util.List;

public interface CategoryServices {
    List<CategoryEntity> findAll();
    public CategoryEntity findById(int id);
}
