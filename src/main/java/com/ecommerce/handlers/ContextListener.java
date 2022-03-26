package com.ecommerce.handlers;


import com.ecommerce.presentation.beans.CategoryBean;
import com.ecommerce.repositories.entites.CategoryEntity;
import com.ecommerce.services.impls.CategoryServicesImpl;
import com.ecommerce.utils.mappers.CategoryMapper;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.util.List;

@WebListener
public class ContextListener implements ServletContextListener {
    private ServletContext servletContext;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        servletContext=sce.getServletContext();
        setCategories();
    }

    private void setCategories() {
        List<CategoryEntity> currentCategory = CategoryServicesImpl.getInstance().findAll();
        List<CategoryBean>currentCategoryBeans = CategoryMapper.INSTANCE.listEntitiesToBeans(currentCategory);
        servletContext.setAttribute("currentCategories",currentCategoryBeans);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Connector.getInstance().close();
    }
}
