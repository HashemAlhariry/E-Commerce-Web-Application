package com.ecommerce.repositories;

import com.ecommerce.repositories.entites.OrderDetailsEntity;
import com.ecommerce.repositories.entites.ProductEntity;

import java.util.List;

public interface OrderDetailRepository extends Repository<OrderDetailsEntity,Integer>{
List<OrderDetailsEntity>findAllById(int id);

}
