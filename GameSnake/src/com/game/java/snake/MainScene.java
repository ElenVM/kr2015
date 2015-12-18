package com.game.java.snake;


import com.game.java.snake.Apple;
import com.game.java.snake.BodyPart;
import com.game.java.snake.Direction;
import com.game.java.snake.Snake;

import java.awt.*;

import static com.game.java.snake.Constant.*;

/**
 * Created by Елена Мирошниченко on 15.12.2015.
 */
public class MainScene extends Scence {
    private Snake snake;
    private Apple apple;

    public MainScene(Game game) {
        super(game);
        snake = new Snake(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, Direction.RIGHT); //значит что змейка будет появляться в середине экрана
        placeApple();
    }

    @Override
    public void update(long nanosPassed) {

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

}
