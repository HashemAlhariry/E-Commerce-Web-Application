package com.ecommerce.presentation.beans;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class SignUpBean {

    private String userName;
    private LocalDate dateOfBirth;
    private String email;
    private String pass;
    private String address;


    public SignUpBean( String userName, LocalDate dateOfBirth, String email, String pass, String address) {
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.pass = pass;
        this.address = address;
    }



    public SignUpBean() {

    }


    @Override
    public String toString() {
        return "LoginSignUpBean{" +
                ", name='" + userName + '\'' +
                ", birthday=" + dateOfBirth + '\'' +
                ", email=" + email + '\'' +
                ", password='" + pass + '\'' +
                ", address=" + address + '\'' +
                '}';
    }
}
