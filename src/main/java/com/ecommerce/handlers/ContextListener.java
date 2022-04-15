package com.ecommerce.handlers;


import com.ecommerce.presentation.beans.CategoryBean;
import com.ecommerce.repositories.entites.CategoryEntity;
import com.ecommerce.services.CategoryServices;
import com.ecommerce.services.impls.CategoryServicesImpl;
import com.ecommerce.utils.mappers.CategoryMapper;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.util.List;
import java.util.UUID;

@WebListener
public class ContextListener implements ServletContextListener {
    private ServletContext servletContext;
    private final String serverEntityKey = UUID.randomUUID().toString();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        servletContext = sce.getServletContext();
        servletContext.setAttribute("serverEntityKey", serverEntityKey);
        setCategories();
    }

    private void setCategories() {
        CategoryServices categoryServices = new CategoryServicesImpl(serverEntityKey);
        List<CategoryEntity> currentCategory = categoryServices.findAll();
        List<CategoryBean> currentCategoryBeans = CategoryMapper.INSTANCE.listEntitiesToBeans(currentCategory);
        servletContext.setAttribute("currentCategories", currentCategoryBeans);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        EntityMangerUtil.getInstance().closeAll();
        Connector.getInstance().close();
    }
}
