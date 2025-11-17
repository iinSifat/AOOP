package com.example.loginwithdbms;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.event.ActionEvent;

import java.sql.*;

public class LoginSignupController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    // Sign up method
    @FXML
    public void signupUser(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try (Connection conn = DatabaseUtil.getConnection()) {
            String query = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Sign Up Successful");
            alert.show();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Login method
    @FXML
    public void loginUser(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try (Connection conn = DatabaseUtil.getConnection()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Set logged in user info
                UtilsClass.loggedInUserId = rs.getInt("id");

                // Switch to home page after login
                HomeController.navigateToHome(event);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Invalid login credentials.");
                alert.show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
