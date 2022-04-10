package com.ecommerce.services.impls;

import com.ecommerce.presentation.beans.LoginUserBean;
import com.ecommerce.presentation.beans.SignUpBean;
import com.ecommerce.repositories.entites.UserEntity;
import com.ecommerce.repositories.impl.UserRepositoryImpl;
import com.ecommerce.utils.mappers.UserMapper;

public class UserUpdateServicesImpl {

    private final static UserUpdateServicesImpl INSTANCE = new UserUpdateServicesImpl();


    private final UserRepositoryImpl userRepository = UserRepositoryImpl.getInstance();


    public static UserUpdateServicesImpl getInstance() {
        return INSTANCE;
    }

    public SignUpBean updateUser(SignUpBean userDto) {

        UserEntity userUpdated = userRepository.findByEmail(userDto.getEmail());
        userUpdated.setUserName(userDto.getUserName());
        userUpdated.setAddress(userDto.getAddress());
        userUpdated.setDateOfBirth(userDto.getDateOfBirth());

        System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu: " + userDto);
        userUpdated = userRepository.update(userUpdated);
        SignUpBean userDTO1 = UserMapper.INSTANCE.userRegEntityToBean(userUpdated);
        System.out.println("update" + userDTO1);
        return userDTO1;

    }



}
