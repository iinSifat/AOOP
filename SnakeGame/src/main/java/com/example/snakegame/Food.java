package com.example.snakegame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.Random;

public class Food {
    private Rectangle food;
    private Random random = new Random();

    public Food() {
        food = new Rectangle(SnakeGame.TILE_SIZE, SnakeGame.TILE_SIZE, Color.RED);
        respawn();
    }

    public void respawn() {
        int x = random.nextInt(SnakeGame.GRID_WIDTH) * SnakeGame.TILE_SIZE;
        int y = random.nextInt(SnakeGame.GRID_HEIGHT) * SnakeGame.TILE_SIZE;
        food.setX(x);
        food.setY(y);
    }

    public Rectangle getFood() {
        return food;
    }
}
