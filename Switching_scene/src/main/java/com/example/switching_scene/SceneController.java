package com.example.switching_scene;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent parent;

    public void ChangeToScene2(ActionEvent e) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Scene2.fxml"));
        parent = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        scene.setFill(Color.LIGHTSKYBLUE);
        stage.show();

    }

    public void ChangeToScene1(ActionEvent e)throws IOException {
        parent = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        scene.setFill(Color.LIGHTSKYBLUE);
        stage.show();
    }
 public void ChangeToScene3(ActionEvent e)throws IOException {
     parent = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
     stage = (Stage)((Node)e.getSource()).getScene().getWindow();
     scene = new Scene(parent);
     stage.setScene(scene);
     scene.setFill(Color.LIGHTSKYBLUE);
     stage.show();
    }





}