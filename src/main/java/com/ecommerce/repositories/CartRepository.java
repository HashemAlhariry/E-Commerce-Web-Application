package com.ecommerce.repositories;

import com.ecommerce.repositories.entites.CartEntity;
import com.ecommerce.repositories.entites.CartID;

import java.util.List;

public interface CartRepository extends Repository<CartEntity, CartID>{

    public List<CartEntity> getUserCart(int id);
}
