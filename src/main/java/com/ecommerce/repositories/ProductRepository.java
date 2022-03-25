package com.ecommerce.repositories;


import com.ecommerce.repositories.entites.ProductEntity;

import java.util.List;

public interface ProductRepository extends Repository<ProductEntity,Long> {
    List<ProductEntity> getLast10();
}
