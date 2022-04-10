package com.ecommerce.utils.mappers;

import com.ecommerce.presentation.beans.AdminOrderBean;
import com.ecommerce.repositories.entites.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AdminOrderMapper {
    AdminOrderMapper INSTANCE = Mappers.getMapper(AdminOrderMapper.class);

    OrderEntity adminOrderBeanToEntity(AdminOrderBean adminOrderBean);

    AdminOrderBean orderEntityToBean(OrderEntity orderEntity);

    List<OrderEntity> listBeansToEntities(List<AdminOrderBean> adminOrderBeans);

    List<AdminOrderBean> listEntitiesToBeans(List<OrderEntity> orderDetailsEntities);
}
