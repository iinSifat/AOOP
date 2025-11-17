package com.example.loginwithdbms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable {

    @FXML
    private Button logout_btn;
    @FXML
    private Label userinfo;
    @FXML
    private Button viewPosts;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Handle logout
        logout_btn.setOnAction(event -> {
            UtilsClass.loggedInUserId = -1; // Reset logged-in user ID
            UtilsClass.changeScene(event, "Main.fxml", "Log in!", null, null);
        });
    }

    @FXML
    public void switchToSecondScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SecondScene.fxml"));
            Scene secondScene = new Scene(loader.load());

            // Get the stage and set the second scene
            Stage stage = (Stage) viewPosts.getScene().getWindow();
            stage.setScene(secondScene);
        } catch (Exception e) {
            showErrorAlert("Unable to load Second Scene. Please try again later.");
            e.printStackTrace();
        }
    }

    @FXML
    public void switchToPostScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("firstscene.fxml"));
            Scene postScene = new Scene(loader.load());

            // Get the stage and set the post scene
            Stage stage = (Stage) viewPosts.getScene().getWindow();
            stage.setScene(postScene);
        } catch (Exception e) {
            showErrorAlert("Unable to load Post Scene. Please try again later.");
            e.printStackTrace();
        }
    }

    public void SetUserinfo(String username) {
        userinfo.setText("Hi " + username + "!");
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.show();
    }
}
