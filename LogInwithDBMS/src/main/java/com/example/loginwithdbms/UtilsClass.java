package com.example.loginwithdbms;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Stack;

public class UtilsClass {
    public static int loggedInUserId = -1;

    public static void changeScene(ActionEvent event, String fxmlFile, String title, String username,String password){
        Parent root = null;
        if(username != null ) {
            try {
                FXMLLoader loader = new FXMLLoader(UtilsClass.class.getResource(fxmlFile));
                root = loader.load();
                LoggedInController loggedInController = loader.getController();
                loggedInController.SetUserinfo(username);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else{
            try{
                root = FXMLLoader.load(UtilsClass.class.getResource(fxmlFile));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void signupUser(ActionEvent event, String username, String password){
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheck = null;
        ResultSet resultSet = null;

        try{
            connection = DatabaseUtil.getConnection();
           // connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posttutorial","root","#Sifat10919");
            psCheck = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            psCheck.setString(1,username);
            resultSet = psCheck.executeQuery();

            if(resultSet.isBeforeFirst()){
                System.out.println("User already exists");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You can not use this name");
                alert.show();
            }
            else {
                psInsert = connection.prepareStatement("INSERT INTO users(username, password) VALUES(?, ?)");
                psInsert.setString(1,username);
                psInsert.setString(2,password);
                psInsert.executeUpdate();

                changeScene(event,"login.fxml","Welcome",username,password);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(resultSet!= null){
                try{
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(psCheck!=null)
            {
                try{
                psCheck.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
            if(psInsert!=null){
                try{
                    psInsert.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(connection!=null){
                try{
                    connection.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void loginUser(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establish a connection to the database
            connection = DatabaseUtil.getConnection();

            // Query to fetch user ID and password for the provided username
            String query = "SELECT id, password FROM users WHERE username = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) { // No user found
                System.out.println("User not found in database!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided credentials are incorrect!");
                alert.show();
            } else {
                resultSet.next(); // Move to the first (and only) row

                String retrievedPassword = resultSet.getString("password");
                int userId = resultSet.getInt("id"); // Get user ID

                // Compare passwords
                if (retrievedPassword.equals(password)) {
                    // Set the logged-in user ID globally
                    loggedInUserId = userId;

                    // Navigate to the desired scene
                    changeScene(event, "login.fxml", "Welcome", username, retrievedPassword);
                    System.out.println("User logged in successfully with ID: " + loggedInUserId);
                } else { // Password mismatch
                    System.out.println("Password is incorrect!");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Provided credentials are incorrect!");
                    alert.show();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Close resources in reverse order of opening
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}





