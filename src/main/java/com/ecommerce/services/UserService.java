package com.ecommerce.services;

import com.ecommerce.exceptions.FoundBeforeException;
import com.ecommerce.presentation.beans.SignUpBean;
import com.ecommerce.presentation.beans.UserViewBean;

import java.util.List;

public interface UserService {
    List<UserViewBean>viewAll();
    List<UserViewBean> viewUserByEmail(String email);
    boolean registerUser (SignUpBean signUpBean) throws FoundBeforeException;
    boolean checkUserEmail (String email);
}
