package com.ecommerce.handlers.filters;

import com.ecommerce.presentation.beans.UserBean;
import com.ecommerce.services.LoginServices;
import com.ecommerce.services.impls.LoginServicesImpl;
import com.ecommerce.utils.Util;
import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();

        if (session.getAttribute("userBean") == null) {
            LoginServices loginServiceImpl = new LoginServicesImpl((String) httpRequest.getAttribute("reqId"));

            Cookie[] cookies = httpRequest.getCookies();

            Cookie userIdCookie = getCookieByName(cookies, "UIDCookie");

            if (userIdCookie != null) {
                UserBean userBean = loginServiceImpl.findUserById(Integer.parseInt(Util.decodeString(userIdCookie.getValue())));
                session.setAttribute("userBean", userBean);
                session.setAttribute("loggedIn", "true");
            }
        }
        chain.doFilter(request,response);
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
