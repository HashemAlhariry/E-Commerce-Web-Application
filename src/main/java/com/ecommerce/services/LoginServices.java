package com.ecommerce.services;

import com.ecommerce.presentation.beans.UserBean;

public interface LoginServices {


    UserBean findUserByEmail(String email);
}
