package com.example.exit_logoutbutton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {
   @FXML
   Button LogoutButton;
   @FXML
   AnchorPane scenePane;
   Stage stage;
   public void logout(ActionEvent event){
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       alert.setTitle("Log Out");
       alert.setHeaderText("Log out Window.");
       alert.setContentText("Are you sure?");
       //Getting the stage we are working with
       if(alert.showAndWait().get() == ButtonType.OK) {
           stage = (Stage) scenePane.getScene().getWindow();
           System.out.println("Log out successfully!");
           stage.close();
       }
   }

}