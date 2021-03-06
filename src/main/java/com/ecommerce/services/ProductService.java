package com.ecommerce.services;

import com.ecommerce.exceptions.CustomValidationException;
import com.ecommerce.presentation.beans.AddProductBean;
import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.repositories.entites.ProductEntity;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    ProductEntity save(AddProductBean addProductBean) throws IOException, CustomValidationException;
    boolean delete(ProductEntity entity);
    ProductEntity findById(Long id);
    List<ProductEntity> findAll();
    ProductEntity update(ProductEntity entity);
    List<ProductEntity>getLast10();
    List<ProductEntity> findAllByCategoryId(int id);
    List<ProductBean> getAllProductBeans(List<Long> ids);
    List<ProductBean> getProductsOfPage(int pageNumber);
    int getAllProductsCount();
    List<ProductEntity> findProductByName(String productName);
    List<ProductEntity> findProductByPrice(BigDecimal productPrice);
    List<ProductEntity> findProductByPriceAndCategoryId(BigDecimal productPrice, int id);


    List<ProductBean> getFilteredProductsBeans(int pageNumber, int recordsPerPage, List<String> categoriesIds);
    long getProductsCountInCategories(String...categoriesIdArr);

    List<ProductEntity> relatedProducts(int id);


}
