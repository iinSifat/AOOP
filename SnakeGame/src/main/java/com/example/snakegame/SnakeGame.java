package com.example.snakegame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SnakeGame extends Application {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    public static final int TILE_SIZE = 20;
    public static final int GRID_WIDTH = WIDTH / TILE_SIZE;
    public static final int GRID_HEIGHT = HEIGHT / TILE_SIZE;

    // Store root as a field so we can update it later
    private Pane root;
    private Snake snake;
    private Food food;
    private int directionX = 1; // Moving right initially
    private int directionY = 0;
    private Timeline gameLoop;

    @Override
    public void start(Stage primaryStage) {
        root = new Pane();
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        snake = new Snake(GRID_WIDTH / 2, GRID_HEIGHT / 2);
        food = new Food();

        // Add initial snake body and food to the scene
        root.getChildren().addAll(snake.getBody());
        root.getChildren().add(food.getFood());

        // Handle key events for movement
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    if (directionY == 0) { directionX = 0; directionY = -1; }
                    break;
                case DOWN:
                    if (directionY == 0) { directionX = 0; directionY = 1; }
                    break;
                case LEFT:
                    if (directionX == 0) { directionX = -1; directionY = 0; }
                    break;
                case RIGHT:
                    if (directionX == 0) { directionX = 1; directionY = 0; }
                    break;
            }
        });

        // Game loop to move the snake
        gameLoop = new Timeline(new KeyFrame(Duration.millis(150), e -> moveSnake()));
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        gameLoop.play();

        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void moveSnake() {
        snake.move(directionX, directionY);

        // Check for border collision
        double headX = snake.getHead().getX();
        double headY = snake.getHead().getY();
        if (headX < 0 || headX >= WIDTH || headY < 0 || headY >= HEIGHT) {
            gameLoop.stop();
            System.out.println("Game Over! Snake hit the wall.");
            return;
        }

        // Check if the snake eats the food
        if (snake.getHead().getBoundsInParent().intersects(food.getFood().getBoundsInParent())) {
            food.respawn();
            snake.grow();
            // Add the new segment to the Pane so it becomes visible
            root.getChildren().add(snake.getBody().getLast());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
