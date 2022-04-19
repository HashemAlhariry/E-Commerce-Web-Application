package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.UserBean;
import com.ecommerce.services.CartService;
import com.ecommerce.services.impls.CartServiceImpl;
import com.ecommerce.utils.CommonString;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
@WebServlet(name = "admin-logout", urlPatterns = {"/admin-logout"})

public class AdminLogout extends HttpServlet {

    @Override
    public void init(ServletConfig config) {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        UserBean userBean = (UserBean) session.getAttribute("userBean");

        Cookie[] cookies = request.getCookies();
        session.invalidate();
        removeCookies(cookies, response);
        System.out.println("d5l hena");
        response.sendRedirect("/home");
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home");
//        requestDispatcher.forward(request, response);

    }

    private void removeCookies(Cookie[] cookies, HttpServletResponse response) {
        if (cookies!=null){
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                cookie.setValue("");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }

}
