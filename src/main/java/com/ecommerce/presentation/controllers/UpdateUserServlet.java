package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.LoginUserBean;
import com.ecommerce.presentation.beans.SignUpBean;
import com.ecommerce.services.impls.UserUpdateServicesImpl;
import com.ecommerce.utils.CommonString;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@WebServlet(name = "updateprofile", urlPatterns = {"/updateprofile"})
public class UpdateUserServlet extends HttpServlet {

    //private final LoginServicesImpl loginServicesImpl = LoginServicesImpl.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // req.setAttribute("data", req.getSession().getAttribute("userDto"));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL + "updateUserProfile.jsp");
        requestDispatcher.forward(req, resp);
    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserUpdateServicesImpl userUpdateServicesImpl = new UserUpdateServicesImpl((String) req.getAttribute("reqId"));
        LoginUserBean loginUserBean = (LoginUserBean) req.getSession().getAttribute("userDto");
        SignUpBean userUpdateBean = new SignUpBean();
        userUpdateBean.setEmail(loginUserBean.getEmail());

        String userName = req.getParameter("update-name");
        String date = req.getParameter("update-birthday");
//        String email = req.getParameter("update-email");
//        String pass = req.getParameter("update-password");
        String address = req.getParameter("update-address");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(date, dateTimeFormatter);


        userUpdateBean.setUserName(userName);
        userUpdateBean.setDateOfBirth(dateOfBirth);
//        userUpdateBean.setEmail(email);
//        userUpdateBean.setPass(pass);
        userUpdateBean.setAddress(address);

        SignUpBean userDto = userUpdateServicesImpl.updateUser(userUpdateBean);

        req.getSession().setAttribute("userDto", userDto);

    }


}

