package com.example.javafx_tutorial_2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Group root = new Group();
        Scene scene1 = new Scene(root,500,500, Color.LIGHTSKYBLUE);

        //Adding text ohn the scene
        Text text = new Text();
        text.setText("\" Hello World! \"");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Ink Free",50));
        text.setFill(Color.LIMEGREEN);


        //Line
        Line line = new Line();
        line.setStartX(100);
        line.setStartY(100);
        line.setEndX(200);
        line.setEndY(100);
        line.setFill(Color.BLACK);
        line.setStrokeWidth(5);
//      line.setOpacity(5);
        line.setStroke(Color.RED);

        //Rectangle
        Rectangle rectangle = new Rectangle();
        rectangle.setX(250);
        rectangle.setY(250);
        rectangle.setWidth(100);
        rectangle.setHeight(100);
        rectangle.setFill(Color.BLACK);
        rectangle.setStrokeWidth(5);
        rectangle.setStroke(Color.WHITE);

        //Triangle
        Polygon triangle = new Polygon();
        triangle.getPoints().setAll(
                350.0,50.0,
                250.0,150.0,
                450.0, 150.0
        );
        triangle.setFill(Color.YELLOW);
        triangle.setRotate(45);

        //Circle
        Circle circle = new Circle();
        circle.setCenterX(400);
        circle.setCenterY(210);
        circle.setRadius(50);
        circle.setStrokeWidth(5);
        circle.setStroke(Color.RED);
        circle.setFill(Color.ORANGERED);

        //Button
        Button button = new Button();
        button.setText("Sifat");
        button.setLayoutX(450);
        button.setLayoutY(450);
        //button.setBackground(new Background(new BackgroundFill(Color.RED,null,null)));

        //Viewing an image of mine with the button click
        Image sifat = new Image(new FileInputStream("E:\\AOOP\\JAvaFx_Tutorial_2\\src\\sifat.jpg"));
        ImageView SifatView = new ImageView(sifat);
        SifatView.setFitWidth(200);
        SifatView.setFitHeight(200);
        SifatView.setX(50);
        SifatView.setY(200);
        button.setOnAction(e-> {
            root.getChildren().add(SifatView);
        });


        stage.setScene(scene1);
        root.getChildren().add(text);
        root.getChildren().add(line);
        root.getChildren().add(rectangle);
        root.getChildren().add(triangle);
        root.getChildren().add(circle);
        root.getChildren().add(button);


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}