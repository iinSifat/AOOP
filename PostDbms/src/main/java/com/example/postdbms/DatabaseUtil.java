package com.example.postdbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/posttutorial";
    private static final String USER = "root";
    private static final String PASSWORD = "#Sifat10919";

    // Get a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
