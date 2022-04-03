package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.SignUpBean;
import com.ecommerce.services.RegisterServices;
import com.ecommerce.services.impls.RegisterServicesImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@WebServlet(name = "SignUp", urlPatterns = "/registration")
public class SignUpServlet extends HttpServlet {

    private final RegisterServices  registerServicesImpl = RegisterServicesImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

   }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        String firstName = req.getParameter("register-name");
        String birthDate = req.getParameter("register-birthday");
        String email = req.getParameter("register-email");
        String password = req.getParameter("register-password");
        String job = req.getParameter("register-job");
        String address = req.getParameter("register-address");
        String creditLimit = req.getParameter("register-credit limit");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(birthDate, dateTimeFormatter);

        SignUpBean userRegistrationBean = new SignUpBean(firstName,String.valueOf(dateOfBirth),email,password,job,address,creditLimit);

        userRegistrationBean.setUserName(firstName);
        userRegistrationBean.setUserEmail(email);
        userRegistrationBean.setUserPassword(password);
        userRegistrationBean.setUserAddress(address);
        userRegistrationBean.setUserBirthDay(String.valueOf(dateOfBirth));
        userRegistrationBean.setUserCreditLimit(creditLimit);
        userRegistrationBean.setUserJob(job);


        SignUpBean signUpBean = registerServicesImpl.registerUser(userRegistrationBean);
        req.getSession().setAttribute("userDto", signUpBean);

    }
}
