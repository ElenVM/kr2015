package com.game.java.snake;


import com.game.java.snake.Apple;
import com.game.java.snake.BodyPart;
import com.game.java.snake.Direction;
import com.game.java.snake.Snake;

import java.awt.*;
import java.awt.event.KeyEvent;

import java.util.List;

import static com.game.java.snake.Constant.*;

/**
 * Created by Елена Мирошниченко on 15.12.2015.
 */
public class MainScence extends Scence {
    private Snake snake;
    private Apple apple;
    private Delay snakeMoveDelay;

    public MainScence(Game game) {
        super(game);
        snake = new Snake(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, Direction.RIGHT); //значит что змейка будет появляться в середине экрана
        placeApple();
        snakeMoveDelay = new Delay(300);    //змейка двигается каждые 300 миллисекунд
    }

    @Override
    public void update(long nanosPassed) {
        processInput();
        if (snakeMoveDelay.updateAndCheck(nanosPassed)) {
            snake.move();
            BodyPart head = snake.head();
            if (head.getX() < 1) {
                head.setX(WORLD_WIDTH);
            }
            if (head.getX() > WORLD_WIDTH) {
                head.setX(1);
            }
            if (head.getY() < 1) {
                head.setY(WORLD_HEIGHT);
            }
            if (head.getY() > WORLD_HEIGHT) {
                head.setY(1);
            }
            if (head.getX() == apple.getX() && head.getY() == apple.getY()) {
                List<BodyPart> body = snake.getBody();
                BodyPart lastPart = body.get(body.size() - 1);
                body.add(new BodyPart(lastPart.getX(), lastPart.getY()));
                placeApple();
            }
        }
    }


    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, game.getScreenSize().width, game.getScreenSize().height);
        drawSnake(g);
        drawApple(g);
    }

    private void drawSnake(Graphics2D g) {
        g.setColor(Color.red);
        for (BodyPart bodyPart : snake.getBody()) {
            g.fillRect(
                    bodyPart.getX() * CELL_SIZE - CELL_SIZE,
                    game.getScreenSize().height - (bodyPart.getY() * CELL_SIZE),
                    CELL_SIZE,
                    CELL_SIZE
            );
        }
    }
    private void drawApple(Graphics2D g) {
        g.setColor(Color.green);
        g.fillRect(
                apple.getX() * CELL_SIZE - CELL_SIZE,
                game.getScreenSize().height - (apple.getY() * CELL_SIZE),
                CELL_SIZE,
                CELL_SIZE
        );
    }
    private void placeApple() {
        int x = 1 + (int)(Math.random() * WORLD_WIDTH);
        int y = 1 + (int)(Math.random() * WORLD_HEIGHT);
        while (!isCellEmpty(x, y)) {
            if (x < WORLD_WIDTH) {
                x++;
            } else {
                if (y < WORLD_HEIGHT) {
                    x = 1;
                    y++;
                } else {
                    x = 1;
                    y = 1;
                }
            }
        }
        apple = new Apple(x, y);
    }
    private boolean isCellEmpty(int x, int y) {
        for (BodyPart bodyPart : snake.getBody()) {
            if (bodyPart.getX() == x && bodyPart.getY() == y) {
                return false;
            }
        }
        return true;
    }


    private void processInput() {
        for (KeyEvent event : game.getInput().getKeyPressedEvents()) {
            switch (event.getKeyCode()) {
                case KeyEvent.VK_UP:
                    snake.setDirection(Direction.UP);
                    break;
                case KeyEvent.VK_RIGHT:
                    snake.setDirection(Direction.RIGHT);
                    break;
                case KeyEvent.VK_DOWN:
                    snake.setDirection(Direction.DOWN);
                    break;
                case KeyEvent.VK_LEFT:
                    snake.setDirection(Direction.LEFT);
                    break;
            }
        }
    }
}
