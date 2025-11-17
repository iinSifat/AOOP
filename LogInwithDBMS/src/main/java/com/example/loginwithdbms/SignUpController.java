package com.example.loginwithdbms;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @FXML
    Button signup_btn;
    @FXML
    Button login_btn;
    @FXML
    TextField username_tf;
    @FXML
    TextField tf_password;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        signup_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!username_tf.getText().isEmpty() && !tf_password.getText().isEmpty()){
                    UtilsClass.signupUser(event,username_tf.getText(),tf_password.getText());
                }
                else {
                    System.out.println("Please fill all the information.");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill all the information !");
                    alert.show();
                }
            }
        });

        login_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UtilsClass.changeScene(event, "Main.fxml","Log in!", null ,null);
            }
        });
    }
}
