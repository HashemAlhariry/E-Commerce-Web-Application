package com.ecommerce.handlers;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext=sce.getServletContext();
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Connector.getInstance().close();
    }
}
