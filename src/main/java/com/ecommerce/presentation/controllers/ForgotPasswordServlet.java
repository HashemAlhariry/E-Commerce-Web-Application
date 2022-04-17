package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.UserBean;
import com.ecommerce.services.UserService;
import com.ecommerce.services.impls.UserServiceImpl;
import com.ecommerce.utils.MailUtil;
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
        UserBean userBean = userService.getUserByEmail(receiverEmail);
        if(userBean != null){
            MailUtil mailUtil = MailUtil.getInstance();
            try {
                mailUtil.sendForgottenPassword("ahmdashrf0097@gmail.com", userBean.getPass());
                out.println("Email Address has been already sent to you, Check your MailBox to recover your password ");
            } catch (EmailException e) {
                out.println(e.getMessage());
            }
        }
        else{
            out.println("The Email Address is Wrongly Entered, you might need to check it again");
        }

    }
}
