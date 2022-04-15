package com.ecommerce.presentation.controllers;

import com.ecommerce.presentation.beans.CartItemBean;
import com.ecommerce.presentation.beans.UserBean;
import com.ecommerce.presentation.beans.ViewCartItem;
import com.ecommerce.services.CartService;
import com.ecommerce.services.LoginServices;
import com.ecommerce.services.impls.CartServiceImpl;
import com.ecommerce.services.impls.LoginServicesImpl;
import com.ecommerce.utils.CommonString;
import com.ecommerce.utils.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "login", urlPatterns = {"/login"})

public class LoginUserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LoginServices loginServiceImpl = new LoginServicesImpl((String) request.getAttribute("reqId"));
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession(false);


        Cookie userIdCookie = getCookieByName(cookies, "UIDCookie");
        Cookie passwordCookie = getCookieByName(cookies, "passwordCookie");

        if (userIdCookie != null && passwordCookie != null) {
            if (session == null) {
                session = request.getSession(true);
            }
            UserBean userBean = loginServiceImpl.findUserById(Integer.parseInt(Util.decodeString(userIdCookie.getValue())));
            session.setAttribute("userBean", userBean);
            session.setAttribute("loggedIn", "true");
            response.sendRedirect("home");
        } else if (session != null && session.getAttribute("userBean") != null) {
            response.sendRedirect("home");
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommonString.HOME_URL + "login.jsp");
            requestDispatcher.forward(request, response);
        }


//        RequestDispatcher requestDispatcher = req.getRequestDispatcher(CommonString.HOME_URL + "login.jsp");
//        requestDispatcher.forward(req, resp);
//        System.out.println("emailjfhushd");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginServices loginServiceImpl = new LoginServicesImpl((String) request.getAttribute("reqId"));
        CartService cartService = new CartServiceImpl((String) request.getAttribute("reqId"));
        String email = request.getParameter("signup-email");
        String password = request.getParameter("signup-password");
        String rememberMe = request.getParameter("rememberMe");
        String cart = request.getParameter("cart");
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession(false);

        UserBean userBean = loginServiceImpl.findUserByEmail(email);
        if (userBean != null) // check against Data Base
        {
            if (userBean.getEmail().equals(email) && userBean.getPass().equals(password) && rememberMe != null) {
                addCookiesToResponse(response, userBean);
            }
            if (session == null) {
                session = request.getSession(true);
            }
            session.setAttribute("userBean", userBean);
            session.setAttribute("loggedIn", "true");
            if (userBean.getRole().equals("CUSTOMER")) {

                //get user cart from json local database
                List<CartItemBean> cartItemBeanListFromJSPJson = Util.parseCartJsonToCartItemBeans(cart, cartService);

                //get user cart from Database
                List<CartItemBean> cartItemBeanListFromDataBase = cartService.getUserCartFromDataBase(userBean.getId());

                List<CartItemBean> cartItemBeans = mergeUserCarts(cartItemBeanListFromJSPJson, cartItemBeanListFromDataBase);
                List<ViewCartItem> viewCartItems = fromCartItemBeansToViewCartItems(cartItemBeans);

                ObjectMapper objectMapper = new ObjectMapper();
                String cartJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(viewCartItems);

                session.setAttribute("cartItemBeans", cartJson);
                response.sendRedirect("home");
            } else if (userBean.getRole().equals("ADMIN")) {
                // add id/password to cookie to user
                addCookiesToResponse(response, userBean);

                //redirect admin page
                response.sendRedirect("admin");
            }
        } else {
            request.setAttribute("errorMessage", "Something wrong in Email or Password");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommonString.HOME_URL + "login.jsp");
            requestDispatcher.forward(request, response);
        }


    }

    private List<ViewCartItem> fromCartItemBeansToViewCartItems(List<CartItemBean> cartItemBeans) {
        List<ViewCartItem> viewCartItems = new ArrayList<>();
        ViewCartItem viewCartItem;
        for (CartItemBean cartItemBean : cartItemBeans) {
            viewCartItem = new ViewCartItem(cartItemBean.getProductBean().getId(), cartItemBean.getRequiredQuantity());
            viewCartItems.add(viewCartItem);
        }
        return viewCartItems;
    }


    private void addCookiesToResponse(HttpServletResponse response, UserBean userBean) {


        //create cookie for user
        // encrypt user id and password and decrypt on use
        String userId = String.valueOf(userBean.getId());
        String userPassword = userBean.getPass();

        Cookie cookieId = new Cookie("UIDCookie", Util.encodeString(userId));
        Cookie cookiePassword = new Cookie("passwordCookie", Util.encodeString(userPassword));

        //30 days for cookie age id
        cookieId.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(cookieId);

        //30 days for cookie age password
        cookiePassword.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(cookiePassword);

    }

    private List<CartItemBean> mergeUserCarts(List<CartItemBean> cartItemBeanListFromJSPJson, List<CartItemBean> cartItemBeanListFromDataBase) {
        List<CartItemBean> cartItemBeans = new ArrayList<>();
        cartItemBeans.addAll(cartItemBeanListFromJSPJson);
        for (CartItemBean cartItemBean : cartItemBeanListFromDataBase) {
            if (!cartItemBeans.contains(cartItemBean)) {
                cartItemBeans.add(cartItemBean);
            }
        }
        return cartItemBeans;
    }

    private Cookie getCookieByName(Cookie[] cookies, String cookieName) {
        Cookie cookie;
        System.out.println("from getCookie method");
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equalsIgnoreCase(cookieName)) {
                    cookie = cookies[i];
                    System.out.println("from getCookie method in if condition");
                    return cookie;
                }
            }
        }

        return null;
    }

}
