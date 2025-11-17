package com.example.image_view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HelloController {

    @FXML
    ImageView myImageView;
    Button button;

    Image image = new Image(getClass().getResource("E:\\AOOP\\Image_View\\src\\main\\resources\\com\\example\\image_view\\Image\\img_3.png").toExternalForm());

    public void Switch() {
        myImageView.setImage(image);
    }





}