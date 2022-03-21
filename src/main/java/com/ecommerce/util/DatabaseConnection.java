package com.ecommerce.util;


import java.sql.Connection;

public enum DatabaseConnection {
    Instance;
    public Connection getConnection() {
        return null;
    }
}
