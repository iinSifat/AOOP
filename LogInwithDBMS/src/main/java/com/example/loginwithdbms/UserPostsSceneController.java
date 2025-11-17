package com.example.loginwithdbms;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserPostsSceneController {

    @FXML
    private FlowPane postFlowPane;

    @FXML
    private Button backButton;

    @FXML
    public void initialize() {
        loadUserPosts();
    }

    public void loadUserPosts() {
        postFlowPane.getChildren().clear(); // Clear previous posts

        try (Connection conn = DatabaseUtil.getConnection()) {
            if (conn == null) {
                System.err.println("Database connection failed!");
                return;
            }

            String query = "SELECT title, content FROM Posts WHERE user_id = ? ORDER BY created_at DESC";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, LogInController.loggedInUserId);

            ResultSet rs = stmt.executeQuery();

            boolean hasPosts = false;
            while (rs.next()) {
                hasPosts = true;
                String title = rs.getString("title");
                String content = rs.getString("content");

                // Create a VBox for each post
                VBox postBox = new VBox(5); // 5px spacing
                postBox.setPrefWidth(250); // Width for posts
                postBox.setStyle("-fx-padding: 10; -fx-border-color: black; -fx-border-width: 1; -fx-background-color: #f9f9f9;");

                // Title Label
                Label titleLabel = new Label(title);
                titleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

                // Content Label
                Label contentLabel = new Label(content);
                contentLabel.setWrapText(true);

                // Add to VBox
                postBox.getChildren().addAll(titleLabel, contentLabel);

                // Add to FlowPane
                postFlowPane.getChildren().add(postBox);
            }

            if (!hasPosts) {
                Label noPostsLabel = new Label("You haven't created any posts yet.");
                noPostsLabel.setStyle("-fx-font-style: italic; -fx-text-fill: gray;");
                postFlowPane.getChildren().add(noPostsLabel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Navigate back to the previous scene
    @FXML
    public void switchToPreviousScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SecondScene.fxml"));
            Scene previousScene = new Scene(loader.load());

            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(previousScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
