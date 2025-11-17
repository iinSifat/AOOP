package com.example.samplelogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerScene1 {
        @FXML
        TextField nametextfield;

       private Stage stage;
       private Scene scene;
       private Parent root;
       @FXML
       public void login(ActionEvent e) throws IOException {
           String username = nametextfield.getText();

           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scene2.fxml"));
           root = fxmlLoader.load();

          ControllerScene2 controllerScene2 = fxmlLoader.getController();
          controllerScene2.displayName(username);
           //root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
           stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
           scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
       }
}