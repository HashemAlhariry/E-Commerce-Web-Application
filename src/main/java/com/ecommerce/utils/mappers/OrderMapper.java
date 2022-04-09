package com.ecommerce.utils.mappers;

import com.ecommerce.presentation.beans.OrderBean;
import com.ecommerce.presentation.beans.OrderDetailsBean;
import com.ecommerce.repositories.entites.OrderDetailsEntity;
import com.ecommerce.repositories.entites.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderEntity OrderBeanToEntity(OrderBean orderBean);
    List<OrderDetailsEntity> OrderDetailsBeanToOrderDetailsEntity(List<OrderDetailsBean> orderDetailsBeanList);
}
