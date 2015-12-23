package com.game.java.snake;


import com.game.java.snake.Apple;
import com.game.java.snake.BodyPart;
import com.game.java.snake.Direction;
import com.game.java.snake.Snake;
import javafx.scene.control.Cell;

import java.awt.*;

import static com.game.java.snake.Constant.*;

/**
 * Created by Елена Мирошниченко on 15.12.2015.
 */
public class MainScence extends Scence {
    private Snake snake;
    private Apple apple;
    private Delay snakeMoveDelay;
    private int delay;
    private int appleCount = 0;
    private int stepsCount = 0;
    private int mlSeconds =0;
    private SidePanel panel;

    public MainScence(Game game,SidePanel panel) {
        super(game);
        snake = new Snake(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, Direction.RIGHT); //значит что змейка будет появляться в середине экрана
        placeApple();
        delay = 200;
        snakeMoveDelay = new Delay(200);    //змейка двигается каждые 300 миллисекунд
        this.panel = panel;
    }
    public MainScence(Game game,SidePanel panel, int delay) {
        super(game);
        snake = new Snake(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, Direction.RIGHT); //значит что змейка будет появляться в середине экрана
        placeApple();
        this.delay = delay;
        snakeMoveDelay = new Delay(delay);    //змейка двигается каждые 300 миллисекунд
        this.panel = panel;
    }
    public MainScence(Game game) {
        super(game);
        snake = new Snake(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, Direction.RIGHT); //значит что змейка будет появляться в середине экрана
        placeApple();
        snakeMoveDelay = new Delay(500);    //змейка двигается каждые 300 миллисекунд
    }

    @Override
    public void update(long nanosPassed) {
<<<<<<< HEAD

        if (isGameOver()) {
            game.setScene(new GameOverScence(game,panel, delay));
            return;
        }

        processInput();

=======
>>>>>>> parent of 1f9625a... 0.0.6
        if (snakeMoveDelay.updateAndCheck(nanosPassed)) {
            stepsCount++;
            mlSeconds+=200;
            String seconds=Clock.getTime(mlSeconds);
            panel.setData(seconds,stepsCount,appleCount);

            snake.move();

            BodyPart head = snake.head();

            //проверка на то что бы змейка не убегала за границы экрана.
            // при достижении одного из краев, она появляется с противоположной стороны
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
<<<<<<< HEAD
            if (head.getX() == apple.getX() && head.getY() == apple.getY()) {
                List<BodyPart> body = snake.getBody();
                BodyPart lastPart = body.get(body.size() - 1);
                body.add(new BodyPart(lastPart.getX(), lastPart.getY()));
                ++appleCount;
                if (isGameOver()){
                    game.setScene(new GameOverScence(game,panel, delay));
                }else {
                    placeApple();
                }

            }
=======
>>>>>>> parent of 1f9625a... 0.0.6
        }


    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, game.getScreenSize().width, game.getScreenSize().height);
        drawSnake(g);
        drawApple(g);
    }

    private void drawSnake(Graphics2D g) {
        g.setColor(panel.getColor());
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
        Color c = new Color(111,111,111);
        g.setColor(c);
        Image img1 = Toolkit.getDefaultToolkit().getImage("/apple.png");
        g.drawImage(img1, apple.getX(), apple.getY(), CELL_SIZE, CELL_SIZE, null);
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

<<<<<<< HEAD

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

    private boolean isGameOver() {
        if (snake.head().getX() == 0 || snake.head().getX() == WORLD_WIDTH ||
                snake.head().getY() == 0 || snake.head().getY() == WORLD_HEIGHT)
            return true;

        for (BodyPart bodyPart : snake.getBody()) {
            if (bodyPart != snake.head()
                    && snake.head().getX() == bodyPart.getX()
                    && snake.head().getY() == bodyPart.getY()) {
                return true;
            }
        }

        return false;
    }
=======
>>>>>>> parent of 1f9625a... 0.0.6
}
