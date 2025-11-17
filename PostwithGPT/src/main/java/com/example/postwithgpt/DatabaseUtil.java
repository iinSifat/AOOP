package com.example.postwithgpt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    public static String link = "jdbc:mysql://localhost:3306/chatgpt";
    public static String root = "root";
    public static String password ="#Sifat10919";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(link,root,password);
    }
}
