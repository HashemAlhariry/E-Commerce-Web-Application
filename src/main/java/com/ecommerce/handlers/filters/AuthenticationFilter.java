package com.ecommerce.handlers.filters;

import com.ecommerce.utils.CommonString;
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
        else {
            request.setAttribute("errorMessage", "you must login to view this page");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommonString.HOME_URL+"login.jsp");
            requestDispatcher.forward(request,response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
