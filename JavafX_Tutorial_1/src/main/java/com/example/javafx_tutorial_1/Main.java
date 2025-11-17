package com.example.javafx_tutorial_1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Group parent1 = new Group();
        Scene scene = new Scene(parent1, Color.RED);
        stage.setTitle("JavaFX Tutorial - 1");
        stage.setHeight(420);
        stage.setWidth(420);
        stage.setX(50);
        stage.setY(50);

        //Changing icon of the stage
        Image icon = new Image(new FileInputStream("E:\\AOOP\\JavafX_Tutorial_1\\src\\img.png"));
        stage.getIcons().add(icon);

//        stage.setFullScreen(true);
//        stage.setFullScreenExitHint("Press E to Exit");
//        stage.setFullScreenExitKeyCombination(KeyCombination.keyCombination("E")); //manual exit key

        Image Luffy = new Image(new FileInputStream("E:\\AOOP\\JavafX_Tutorial_1\\src\\img_1.png"));
        ImageView imageView = new ImageView(Luffy);
        imageView.setFitHeight(400);
        imageView.setFitWidth(240);

        parent1.getChildren().add(imageView);
        //Button
        Button button = new Button();
        button.setLayoutX(360);
        button.setLayoutY(350);
        button.setText("Next");
        parent1.getChildren().add(button);

        Group parent2 = new Group();
        Scene scene1 = new Scene(parent2,Color.AQUA);
        button.setOnAction(e ->  {
                stage.setScene(scene1);
        });


        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}