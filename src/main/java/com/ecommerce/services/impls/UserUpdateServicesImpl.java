package com.ecommerce.services.impls;

import com.ecommerce.presentation.beans.SignUpBean;
import com.ecommerce.repositories.UserRepository;
import com.ecommerce.repositories.entites.UserEntity;
import com.ecommerce.repositories.impl.UserRepositoryImpl;
import com.ecommerce.utils.mappers.UserMapper;

public class UserUpdateServicesImpl {

    private final UserRepository userRepository;

    public UserUpdateServicesImpl(String reqId) {
        userRepository = new UserRepositoryImpl(reqId);
    }

    public SignUpBean updateUser(SignUpBean userDto) {

        UserEntity userUpdated = userRepository.findByEmail(userDto.getEmail());
        userUpdated.setUserName(userDto.getUserName());
        userUpdated.setAddress(userDto.getAddress());
        userUpdated.setDateOfBirth(userDto.getDateOfBirth());

        userUpdated = userRepository.update(userUpdated);
        SignUpBean userDTO1 = UserMapper.INSTANCE.userRegEntityToBean(userUpdated);
        return userDTO1;

    }


}
