package com.example.loginwithdbms;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SecondSceneController {

    @FXML
    private FlowPane postFlowPane;

    @FXML
    private Button backButton;

    // Load posts from the database when the scene is initialized
    @FXML
    public void initialize() {
        loadPosts();
    }

    public void loadPosts() {
        postFlowPane.getChildren().clear(); // Clear previous posts

        try (Connection conn = DatabaseUtil.getConnection()) {
            String query = "SELECT title, content, image FROM Posts ORDER BY created_at DESC";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String title = rs.getString("title");
                String content = rs.getString("content");
                String imagePath = rs.getString("image");

                // Create a VBox for each post
                VBox postBox = new VBox(5); // 5px spacing between title and content
                postBox.setPrefWidth(200); // Set a preferred width for each post box
                postBox.setStyle("-fx-padding: 10; -fx-border-color: black; -fx-border-width: 1; -fx-background-color: #f9f9f9;");

                // Create and style the title label
                Label titleLabel = new Label(title);
                titleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

                // Create and style the content label
                Label contentLabel = new Label(content);
                contentLabel.setWrapText(true); // Enable text wrapping for long content

                // Add the title and content labels to the VBox
                postBox.getChildren().addAll(titleLabel, contentLabel);

                // Add image if exists
                if (imagePath != null && !imagePath.isEmpty()) {
                    ImageView imageView = new ImageView(new Image(imagePath)); // Load image
                    imageView.setFitWidth(200); // Set the width for the image
                    imageView.setPreserveRatio(true); // Preserve aspect ratio
                    postBox.getChildren().add(imageView); // Add the image to the postBox
                }

                // Add the VBox to the FlowPane
                postFlowPane.getChildren().add(postBox);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Switch back to the first scene
    @FXML
    public void switchToFirstScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FirstScene.fxml"));
            Scene firstScene = new Scene(loader.load());

            // Get the stage and set the first scene
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(firstScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
