package com.ecommerce.utils.mappers;

import com.ecommerce.presentation.beans.AdminOrderDetailsBean;
import com.ecommerce.repositories.entites.OrderDetailsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface AdminOrderDetailsMapper {
    AdminOrderDetailsMapper INSTANCE = Mappers.getMapper(AdminOrderDetailsMapper.class);

    OrderDetailsEntity adminOrderDetailsBeanToEntity(AdminOrderDetailsBean adminOrderDetailsBean);

    AdminOrderDetailsBean orderDetailsEntityToBean(OrderDetailsEntity orderDetailsEntity);

    List<OrderDetailsEntity> listBeansToEntities(List<AdminOrderDetailsBean> adminOrderDetailsBeans);

    List<AdminOrderDetailsBean> listEntitiesToBeans(List<OrderDetailsEntity> orderDetailsEntities);
}
