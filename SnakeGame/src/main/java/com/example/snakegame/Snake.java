package com.example.snakegame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Rectangle> body = new LinkedList<>();

    public Snake(int startX, int startY) {
        Rectangle head = new Rectangle(SnakeGame.TILE_SIZE, SnakeGame.TILE_SIZE);
        head.setX(startX * SnakeGame.TILE_SIZE);
        head.setY(startY * SnakeGame.TILE_SIZE);
        head.setFill(Color.GREEN);
        body.add(head);
    }

    public LinkedList<Rectangle> getBody() {
        return body;
    }

    public Rectangle getHead() {
        return body.getFirst();
    }

    public void move(int directionX, int directionY) {
        // Move body parts forward (from tail to head)
        for (int i = body.size() - 1; i > 0; i--) {
            body.get(i).setX(body.get(i - 1).getX());
            body.get(i).setY(body.get(i - 1).getY());
        }

        // Move head
        Rectangle head = getHead();
        head.setX(head.getX() + directionX * SnakeGame.TILE_SIZE);
        head.setY(head.getY() + directionY * SnakeGame.TILE_SIZE);
    }

    public void grow() {
        // Create new segment at the tail's position
        Rectangle tail = body.getLast();
        Rectangle newPart = new Rectangle(SnakeGame.TILE_SIZE, SnakeGame.TILE_SIZE);
        newPart.setFill(Color.GREEN);
        newPart.setX(tail.getX());
        newPart.setY(tail.getY());
        body.add(newPart);
    }
}
