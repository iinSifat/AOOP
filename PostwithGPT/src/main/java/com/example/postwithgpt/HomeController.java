package com.example.postwithgpt;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert;
import javafx.fxml.FXMLLoader;

import java.sql.*;

public class HomeController {

    @FXML private TextField titleField;
    @FXML private TextArea contentField;

    // Handle creating post
    @FXML
    public void createPost(ActionEvent event) {
        String title = titleField.getText();
        String content = contentField.getText();

        if (!title.isEmpty() && !content.isEmpty()) {
            try (Connection conn = DatabaseUtil.getConnection()) {
                String query = "INSERT INTO posts (user_id, title, content) VALUES (?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, UtilsClass.loggedInUserId);
                stmt.setString(2, title);
                stmt.setString(3, content);
                stmt.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Post Created Successfully!");
                alert.show();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill all fields!");
            alert.show();
        }
    }

    // View the user's posts
    @FXML
    public void viewUserPosts(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("userPosts.fxml"));
            Scene userPostsScene = new Scene(loader.load());
            // Set the scene to show user's posts
            Stage stage = (Stage) titleField.getScene().getWindow();
            stage.setScene(userPostsScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View all users' posts
    @FXML
    public void viewAllPosts(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("allPosts.fxml"));
            Scene allPostsScene = new Scene(loader.load());
            // Set the scene to show all posts
            Stage stage = (Stage) titleField.getScene().getWindow();
            stage.setScene(allPostsScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Navigate to home page after login
    public static void navigateToHome(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(HomeController.class.getResource("home.fxml"));
            Scene homeScene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(homeScene);
            stage.show();
        } catch (IOException e
