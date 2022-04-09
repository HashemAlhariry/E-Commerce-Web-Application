package com.ecommerce.services;

import com.ecommerce.presentation.beans.LoginUserBean;

public interface LoginServices {


    LoginUserBean findUserByEmail(String email);
}
