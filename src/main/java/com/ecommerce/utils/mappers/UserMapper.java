package com.ecommerce.utils.mappers;

import com.ecommerce.presentation.beans.LoginUserBean;
import com.ecommerce.presentation.beans.SignUpBean;
import com.ecommerce.presentation.beans.UserBean;
import com.ecommerce.repositories.entites.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity userBeanToEntity(LoginUserBean userBean);
    LoginUserBean userEntityToBean(UserEntity userEntity);


    UserEntity userRegBeanToEntity(SignUpBean userBean);
    SignUpBean userRegEntityToBean(UserEntity userEntity);

    UserBean userEntityToUserBean(UserEntity userEntity);

}
