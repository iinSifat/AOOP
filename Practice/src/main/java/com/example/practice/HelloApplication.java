package com.example.practice;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Scene scene1 = new Scene(root,420,420, Color.AQUA);
        Image icon = new Image(new FileInputStream("E:\\AOOP\\Practice\\src\\img.png"));
        stage.getIcons().add(icon);
        stage.setScene(scene1);


        Image image = new Image(new FileInputStream("E:\\AOOP\\Practice\\src\\img.png"));
        ImageView newImage = new ImageView(image);
        newImage.setFitHeight(200);
        newImage.setFitWidth(200);
        newImage.setX(50);
        newImage.setY(50);

        Text text = new Text();
        text.setText("Button Pressed!");
        text.setX(50);
        text.setY(400);
        text.setFont(Font.font("Times New Roman",20));

        Button nextButton = new Button();
        nextButton.setLayoutX(300);
        nextButton.setLayoutY(50);
        nextButton.setText("Next");

        Button prev = new Button();
        prev.setLayoutX(300);
        prev.setLayoutY(50);
        prev.setText("Prev");

        Group root1 = new Group();
        Scene scene2 = new Scene(root1,420,420,Color.BLACK);

        nextButton.setOnAction( e->{
            stage.setScene(scene2);

        });

        prev.setOnAction(e ->{
            stage.setScene(scene1);
        });




        root.getChildren().add(newImage);
        root.getChildren().add(text);
        root.getChildren().add(nextButton);
        root1.getChildren().add(prev);

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}