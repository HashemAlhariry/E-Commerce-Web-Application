package com.ecommerce.presentation.beans;

import com.ecommerce.utils.ValidationUtil;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SignUpBean {
    @Size(min = 2, message = "Your username must be at least 2 characters long")
    private String userName;
    @NotNull(message = "dateOfBirth can't be null")
    private LocalDate dateOfBirth;
    @NotNull(message = "email cannot ")
    private String email;
    @Size(min = 8, message = "Your password must be at least 8 characters long")
    private String pass;
    @NotNull(message = "address can't be null")
    private String address;
    private int id;


    public SignUpBean(String userName, LocalDate dateOfBirth, String email, String pass, String address) {
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.pass = pass;
        this.address = address;
        ValidationUtil.getInstance().validate(this);
    }


    public SignUpBean() {

    }


    @Override
    public String toString() {
        return "LoginSignUpBean{" +
                "name='" + userName + '\'' +
                ", birthday=" + dateOfBirth + '\'' +
                ", email=" + email + '\'' +
                ", password='" + pass + '\'' +
                ", address=" + address + '\'' +
                '}';
    }
}
