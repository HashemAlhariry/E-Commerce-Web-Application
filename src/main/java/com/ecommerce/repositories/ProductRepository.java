package com.ecommerce.repositories;


import com.ecommerce.repositories.entites.ProductEntity;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends Repository<ProductEntity,Long> {
    List<ProductEntity> getLast10();
    List<ProductEntity> findAllByCategoryId(int id);
    List<ProductEntity> findProductByName(String productName);
    List<ProductEntity> findProductByPrice(BigDecimal productPrice);


}
