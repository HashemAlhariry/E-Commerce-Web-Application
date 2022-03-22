package com.ecommerce.repositories;


import com.ecommerce.presentation.beans.ProductBean;

import java.util.List;

public interface ProductRepository {

    void insertProduct(ProductBean productBean);
    List<ProductBean> getAllProduct();

}
