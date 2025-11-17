package com.example.loginwithdbms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class FirstSceneController {

    @FXML
    private TextArea postTextArea;

    @FXML
    private TextField titleTextField; // New TextField for title

    @FXML
    private Button submitButton;

    @FXML
    private Button switchSceneButton;
    @FXML
    private Button switchSceneButton1;
    @FXML
    private Button switchToUserPostsButton; // Button for UserPostScene

    @FXML
    private ImageView postImageView;

    private String imagePath = null; // To store the image path

    // Open file chooser to select an image
    @FXML
    public void selectImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jpeg"));
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            imagePath = selectedFile.toURI().toString(); // Store the image path
            postImageView.setImage(new Image(imagePath)); // Display the image in ImageView
        }
    }

    // Submit post with title, content, and image to the database
    @FXML
    public void submitPost() {
        String title = titleTextField.getText().trim();
        String content = postTextArea.getText().trim();

        if (!title.isEmpty() && !content.isEmpty() && imagePath != null) {
            try (Connection conn = DatabaseUtil.getConnection()) {
                String query = "INSERT INTO Posts (title, content, image) VALUES (?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, title); // Set the title
                stmt.setString(2, content); // Set the content
                stmt.setString(3, imagePath); // Set the image path
                stmt.executeUpdate();

                postTextArea.clear(); // Clear TextArea after posting
                titleTextField.clear(); // Clear title field after posting
                postImageView.setImage(null); // Clear ImageView after posting
                imagePath = null; // Reset image path
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    // Switch to the second scene
    @FXML
    public void switchToSecondScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SecondScene.fxml"));
            Scene secondScene = new Scene(loader.load());
            Stage stage = (Stage) switchSceneButton.getScene().getWindow();
            stage.setScene(secondScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Switch to the main scene (Login)
    @FXML
    public void switchToMainScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Scene mainScene = new Scene(loader.load());
            Stage stage = (Stage) switchSceneButton1.getScene().getWindow();
            stage.setScene(mainScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Switch to the UserPostScene
    @FXML
    public void switchToUserPostScene(ActionEvent e) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UserPostScene.fxml"));
            Scene userPostScene = new Scene(loader.load());

            // Get the stage and set the UserPostScene
            Stage stage = (Stage) switchToUserPostsButton.getScene().getWindow();
            stage.setScene(userPostScene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
