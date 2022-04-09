package com.ecommerce.utils.mappers;

import com.ecommerce.presentation.beans.NewArrivalProductBean;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.repositories.entites.ProductState;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NewArrivalProductMapper {
    NewArrivalProductMapper INSTANCE = Mappers.getMapper(NewArrivalProductMapper.class);
    @Mapping(source = "state", target = "state", qualifiedByName = "getStateName")
    List<NewArrivalProductBean> listEntitiesToBeans(List<ProductEntity> productEntities);

    default String getStateName(ProductState state) {
        return state.getName();
    }
}
