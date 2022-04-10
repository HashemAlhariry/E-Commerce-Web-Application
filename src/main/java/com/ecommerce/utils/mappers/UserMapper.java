package com.ecommerce.utils.mappers;

import com.ecommerce.presentation.beans.LoginUserBean;
import com.ecommerce.presentation.beans.SignUpBean;
import com.ecommerce.presentation.beans.UserViewBean;
import com.ecommerce.repositories.entites.Role;
import com.ecommerce.repositories.entites.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity userBeanToEntity(LoginUserBean userBean);

    LoginUserBean userEntityToBean(UserEntity userEntity);


    UserEntity userRegBeanToEntity(SignUpBean userBean);

    SignUpBean userRegEntityToBean(UserEntity userEntity);

    @Mapping(source = "role", target = "role", qualifiedByName = "getRoleName")
    UserViewBean userEntityToViewUserBean(UserEntity userEntity);

    @Mapping(source = "role", target = "role", qualifiedByName = "getRoleName")
    List<UserViewBean> userEntitiesToViewUserBeans(List<UserEntity> userEntities);

    @Named("getRoleName")

    default String getRoleName(Role role) {
        return role.toString();
    }

}
