package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.ResponseMessageBean;
import com.ecommerce.presentation.beans.UserBean;
import com.ecommerce.services.UserService;
import com.ecommerce.services.impls.UserServiceImpl;
import com.ecommerce.utils.MailUtil;
import com.google.gson.Gson;
import jakarta.persistence.NoResultException;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.mail.EmailException;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "forgotPassword", urlPatterns = {"/forgotPassword"})
public class ForgotPasswordServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException{

    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl((String)request.getAttribute("reqId"));
        PrintWriter out = response.getWriter();

        String receiverEmail =  request.getParameter("recoveryEmail");
        UserBean userBean = userService.getUserByEmail(receiverEmail.trim());
        if(userBean != null){
            MailUtil mailUtil = MailUtil.getInstance();
            try {
                mailUtil.sendForgottenPassword(userBean.getEmail(), userBean.getPass());
                String message  = "Email has been already sent to you, Check your MailBox to recover your password";
                out.println(new Gson().toJson(message));
            } catch (EmailException e) {
                String message  = "We couldn't send email to you right now , please try again";
                out.println(new Gson().toJson(message));
            }
        }
        else{
            String message = "The Email Address is Wrongly Entered or you don't have an account, you might need to check it again";
            out.println(new Gson().toJson(message));

        }
    }
}
