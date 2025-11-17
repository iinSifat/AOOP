package com.example.loginwithdbms;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable {
    public static int loggedInUserId = -1; // Keeps track of the logged-in user's ID

    @FXML
    private Button login_Btn;

    @FXML
    private Button signup_Btn;

    @FXML
    private TextField usernameTxt;

    @FXML
    private TextField passwordTxt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Event handler for the login button
        login_Btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Log in the user and set the loggedInUserId
                UtilsClass.loginUser(event, usernameTxt.getText(), passwordTxt.getText());
                if (UtilsClass.loggedInUserId != -1) {
                    System.out.println("User logged in with ID: " + UtilsClass.loggedInUserId);
                } else {
                    System.out.println("Login failed!");
                }


            }
        });

        // Event handler for the signup button
        signup_Btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Change to the signup scene
                UtilsClass.changeScene(event, "signup.fxml", "Sign up!", null, null);
            }
        });
    }
}
