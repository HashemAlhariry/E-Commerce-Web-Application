package com.ecommerce.utils.mappers;

import com.ecommerce.presentation.beans.OrderDetailsBean;
import com.ecommerce.repositories.entites.OrderDetailsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface OrderDetailsMapper {
    OrderDetailsMapper INSTANCE = Mappers.getMapper(OrderDetailsMapper.class);

    OrderDetailsEntity orderDetailBeanToEntity(OrderDetailsBean orderDetailsBean);

    OrderDetailsBean orderDetailEntityToBean(OrderDetailsEntity orderDetailsEntity);

    List<OrderDetailsEntity> listBeansToEntities(List<OrderDetailsBean> orderDetailsBeans);

    List<OrderDetailsBean> listEntitiesToBeans(List<OrderDetailsEntity> orderDetailsEntities);

}
