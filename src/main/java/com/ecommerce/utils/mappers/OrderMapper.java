package com.ecommerce.utils.mappers;


import com.ecommerce.presentation.beans.OrderBean;
import com.ecommerce.repositories.entites.OrderEntity;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderEntity orderBeanToEntity(OrderBean productBean);

    OrderBean orderEntityToBean(OrderEntity productEntity);

    List<OrderEntity> listBeansToEntities(List<OrderBean> productBeans);

    List<OrderBean> listEntitiesToBeans(List<OrderEntity> productEntities);
}
