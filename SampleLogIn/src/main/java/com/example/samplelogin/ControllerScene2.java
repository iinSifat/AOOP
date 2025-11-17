package com.example.samplelogin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControllerScene2 {
    @FXML
    Label namelabel;


    public void displayName(String username){
        namelabel.setText("Hello: "+username);
    }
}
