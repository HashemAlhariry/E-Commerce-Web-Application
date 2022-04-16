package com.ecommerce.handlers;

import com.ecommerce.presentation.beans.UserBean;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AuthorizationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        UserBean userBean = (UserBean) httpRequest.getSession().getAttribute("userBean");
        if (userBean != null && userBean.getRole().equalsIgnoreCase("ADMIN") ) {
            filterChain.doFilter(request, response);
        } else {
            request.setAttribute("errorMessage", "you dont have authority to view this page , please login as admin");
            ((HttpServletResponse) response).sendRedirect("login");
        }
    }
}
