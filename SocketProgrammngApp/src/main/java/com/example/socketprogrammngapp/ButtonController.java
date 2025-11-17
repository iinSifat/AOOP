package com.example.socketprogrammngapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class ButtonController {
    private Stage stage;
    private Scene scene;
    private Parent parent;

    public void ChangeToScene1(ActionEvent e)throws IOException {
        parent = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
     //   scene.setFill(Color.LIGHTSKYBLUE);
        stage.setTitle("Messenger interface.");
        stage.show();
    }


}
