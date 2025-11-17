package com.example.loginwithdbms;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        try (Connection conn = DatabaseUtil.getConnection()) {
            System.out.println("Database connection successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}