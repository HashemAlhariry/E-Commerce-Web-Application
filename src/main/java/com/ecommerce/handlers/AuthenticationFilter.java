package com.ecommerce.handlers;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();

        String loggedIn = (String)session.getAttribute("loggedIn");
        if(loggedIn != null && loggedIn.equalsIgnoreCase("true"))
            chain.doFilter(request,response);
        else
            httpResponse.sendRedirect("login");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
