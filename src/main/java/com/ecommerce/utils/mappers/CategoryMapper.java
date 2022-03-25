package com.ecommerce.utils.mappers;

import com.ecommerce.presentation.beans.CategoryBean;
import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.repositories.entites.CategoryEntity;
import com.ecommerce.repositories.entites.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryEntity categoryBeanToEntity(CategoryBean categoryBean);

    CategoryBean categoryEntityToBean(CategoryEntity categoryEntity);

    List<CategoryEntity> listBeansToEntities(List<CategoryBean> categoryBeans);

    List<CategoryBean> listEntitiesToBeans(List<CategoryEntity> categoryEntities);
}
