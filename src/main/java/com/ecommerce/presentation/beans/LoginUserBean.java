package com.ecommerce.presentation.beans;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginUserBean {

    private String email;
    private String pass;
    private String role;

    public LoginUserBean(String userEmail, String userPassword ,String role) {
        this.email = userEmail;
        this.pass = userPassword;
        this.role = role;
    }

    public LoginUserBean() {

    }


    public String getEmail() {
        return email;
    }
    public String getPass() {
        return pass;
    }
    public  String getRole(){
        return role;
    }

    @Override
    public String toString() {
        return "LoginUserBean{" +
                "email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
