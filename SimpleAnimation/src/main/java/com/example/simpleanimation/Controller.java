package com.example.simpleanimation;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ImageView myImage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //translate
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(myImage);
        translate.setByX(250);
        translate.play();

    }
}