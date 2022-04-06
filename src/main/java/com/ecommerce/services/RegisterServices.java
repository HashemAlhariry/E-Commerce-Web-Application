package com.ecommerce.services;

import com.ecommerce.presentation.beans.LoginUserBean;
import com.ecommerce.presentation.beans.SignUpBean;

public interface RegisterServices {

    SignUpBean registerUser (SignUpBean signUpBean);
}
