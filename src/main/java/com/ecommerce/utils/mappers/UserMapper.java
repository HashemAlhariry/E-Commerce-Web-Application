package com.ecommerce.utils.mappers;

import com.ecommerce.presentation.beans.LoginUserBean;
import com.ecommerce.presentation.beans.ProductBean;
import com.ecommerce.repositories.entites.ProductEntity;
import com.ecommerce.repositories.entites.UserEntity;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity userBeanToEntity(LoginUserBean userBean);

    LoginUserBean userEntityToBean(UserEntity userEntity);

}
