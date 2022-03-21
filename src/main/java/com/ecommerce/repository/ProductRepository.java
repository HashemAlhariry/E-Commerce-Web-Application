package com.ecommerce.repository;



import java.util.List;

import com.ecommerce.dto.ProductDto;

public interface ProductRepository {
    void insertProduct(ProductDto productDto);
    List<ProductDto> getAllProduct();
}
