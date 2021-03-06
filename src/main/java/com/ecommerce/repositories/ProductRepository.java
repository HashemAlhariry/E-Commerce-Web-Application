package com.ecommerce.repositories;


import com.ecommerce.repositories.entites.ProductEntity;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends Repository<ProductEntity,Long> {

    List<ProductEntity> getLast10();
    List<ProductEntity> findAllByCategoryId(int id);
//    List<ProductEntity> getSinglePageProducts(int PageNumber , int recordsPerPage);
    List<ProductEntity> findProductByName(String productName);
    List<ProductEntity> findProductByPrice(BigDecimal productPrice);
    List<ProductEntity> findProductByPriceAndCategoryId(BigDecimal productPrice ,int id);
//    int findAllProductsNumber();
    List<ProductEntity> getFilteredProducts(int pageNumber, int recordsPerPage, List<String> categoriesIds);
    long countProductsOfCertainCategories(List<String> categoriesIds);
    List<ProductEntity> relatedProducts(int id);

//    relatedProducts

}
