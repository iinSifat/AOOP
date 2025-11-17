package com.example.simple_animation;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    Rectangle mySquare = new Rectangle();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Translate
      /*  TranslateTransition translate = new TranslateTransition();
        translate.setNode(mySquare);
        translate.setByX(270);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setAutoReverse(true);
        translate.play(); */

        // Rotate
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(mySquare);
        rotate.setDuration(Duration.millis(1000));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setAutoReverse(true);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(360);
        rotate.play();


    }
}