package com.ecommerce.repositories;


import com.ecommerce.repositories.entites.ProductEntity;

import java.util.List;

public interface ProductRepository extends Repository<ProductEntity,Long> {
    List<ProductEntity> getLast10();
    List<ProductEntity> findAllByCategoryId(int id);
//    List<ProductEntity> getSinglePageProducts(int PageNumber , int recordsPerPage);
    List<ProductEntity> findProductByName(String productName);
//    int findAllProductsNumber();



}
