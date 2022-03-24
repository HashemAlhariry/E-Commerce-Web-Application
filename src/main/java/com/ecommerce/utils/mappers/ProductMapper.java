package com.ecommerce.utils.mappers;

import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.repositories.entites.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductEntity productBeanToEntity(ProductBean productBean);

    ProductBean productEntityToBean(ProductEntity productEntity);

    List<ProductEntity> listBeansToEntities(List<ProductBean> productBeans);

    List<ProductBean> listEntitiesToBeans(List<ProductEntity> productEntities);

}