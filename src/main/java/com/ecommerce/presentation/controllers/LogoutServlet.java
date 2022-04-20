package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.UserBean;
import com.ecommerce.services.CartService;
import com.ecommerce.services.impls.CartServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name="logout", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartService cartService=new CartServiceImpl((String) request.getAttribute("reqId"));
        PrintWriter out = response.getWriter();
        String cartJson = request.getParameter("cartItems");
        System.out.println(cartJson+"cartJson");
        HttpSession session = request.getSession();

        UserBean userBean = (UserBean) session.getAttribute("userBean");
        System.out.println(userBean);
        System.out.println(userBean.getId());
        cartService.saveUserCart(cartJson , userBean.getId());
        Cookie[] cookies = request.getCookies();
        session.invalidate();
        removeCookies(cookies, response);



        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(new ArrayList<>());
         out.print(json);


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


