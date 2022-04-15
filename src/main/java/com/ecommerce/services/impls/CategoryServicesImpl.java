package com.ecommerce.services.impls;

import com.ecommerce.repositories.CategoryRepository;
import com.ecommerce.repositories.entites.CategoryEntity;
import com.ecommerce.repositories.impl.CategoryRepositoryImpl;
import com.ecommerce.services.CategoryServices;

import java.util.List;

public class CategoryServicesImpl implements CategoryServices {
    private final CategoryRepository categoryRepository;

    public CategoryServicesImpl(String reqId) {
        categoryRepository = new CategoryRepositoryImpl(reqId);
    }

    @Override
    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity findById(int id) {
        return categoryRepository.findById(id);
    }
}
