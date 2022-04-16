package com.ecommerce.handlers.filters;

import com.ecommerce.presentation.beans.UserBean;
import com.ecommerce.utils.CommonString;
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
            ((HttpServletResponse) response).sendRedirect("404");
        }
    }
}
