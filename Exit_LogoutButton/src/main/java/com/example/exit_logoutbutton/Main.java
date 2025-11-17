package com.example.exit_logoutbutton;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Log out or Exit!");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> //passing event -> lambda function
        {   event.consume();                         //cancel button was closing out the window. that's why
            logout(stage);});                      //we have to consume the event (it will not close the window until user confirms)
    }
    public void logout(Stage stage){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Log Out");
        alert.setHeaderText("Log out Window.");
        alert.setContentText("Are you sure?");
        //Getting the stage we are working with
        if(alert.showAndWait().get() == ButtonType.OK) {
            //stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("Log out successfully!");
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}