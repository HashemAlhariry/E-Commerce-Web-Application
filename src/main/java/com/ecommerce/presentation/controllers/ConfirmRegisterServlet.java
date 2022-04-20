package com.ecommerce.presentation.controllers;

import com.ecommerce.exceptions.NotFoundException;
import com.ecommerce.services.UserService;
import com.ecommerce.services.impls.UserServiceImpl;
import com.ecommerce.utils.CommonString;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConfirmRegisterServlet",urlPatterns = {"/confirmreg"})
public class ConfirmRegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String code = req.getParameter("code");
        UserService userService = new UserServiceImpl((String) req.getAttribute("reqId"));
        boolean isSuccess=false;
        String confMsg="";
        try {
            if(userService.confirmRegister(code)){
                isSuccess=true;
                confMsg="This account has been verified successfully";
            }

        } catch (NotFoundException e) {
            confMsg="This code is invalid";
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL + "login.jsp");
        requestDispatcher.include(req, resp);
        if(isSuccess)
            out.println("<script>showSwal('success-message','"+confMsg+"');</script>");
        else
            out.println("<script>showSwal('warning-message-and-cancel','"+confMsg+"');</script>");



    }
}