package com.game.java.snake;


import com.game.java.snake.Apple;
import com.game.java.snake.BodyPart;
import com.game.java.snake.Direction;
import com.game.java.snake.Snake;
import javafx.scene.control.Cell;

import java.awt.*;
import java.awt.event.KeyEvent;

import java.awt.geom.Rectangle2D;
import java.io.*;
import java.util.Date;
import java.util.List;

import static com.game.java.snake.Constant.*;

/**
 * Created by Helen  Miroshnichenko on 15.12.2015.
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
    private boolean paused = false;

    public MainScence(Game game,SidePanel panel) {
        super(game);
        snake = new Snake(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, Direction.RIGHT);
        placeApple();
        delay = 200;
        snakeMoveDelay = new Delay(200);
        this.panel = panel;
    }

    public MainScence(Game game,SidePanel panel, int delay) {
        super(game);
        snake = new Snake(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, Direction.RIGHT); //значит что змейка будет появляться в середине экрана
        placeApple();
        this.delay = delay;
        snakeMoveDelay = new Delay(delay);
        this.panel = panel;
    }

    public MainScence(Game game) {
        super(game);
        snake = new Snake(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, Direction.RIGHT);
        placeApple();
        snakeMoveDelay = new Delay(500);
    }

    public MainScence(Game game, SidePanel panel, Snake snake, Apple apple, Delay snakeMoveDelay, int delay, int appleCount, int stepsCount, int mlSeconds){
        super(game);
        this.panel = panel;
        this.snake = snake;
        this.apple = apple;
        this.snakeMoveDelay = snakeMoveDelay;
        this.delay = delay;
        this.appleCount = appleCount;
        this.stepsCount = stepsCount;
        this.mlSeconds = mlSeconds;
    }



    //змейка будет двигаться как только нужная задержка была достигнута
    //обрабатывает внесенные изменения и обновляет игровое поле
    @Override
    public void update(long nanosPassed) {

        processInput();
        if (!paused) {
            if (isGameOver()) {
                game.setScene(new GameOverScence(game, panel, delay));
                return;
            }

            if (snakeMoveDelay.updateAndCheck(nanosPassed)) {
                stepsCount++;
                mlSeconds += 200;
                String seconds = Clock.getTime(mlSeconds);
                panel.setData(seconds, stepsCount, appleCount);

                snake.move();   //удлинение змейки, при поедании яблока
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
                    ++appleCount;
                    if (isGameOver()) {
                        game.setScene(new GameOverScence(game, panel, delay));
                    } else {
                        placeApple();
                    }

                }
            }
        }
    }


    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, game.getScreenSize().width, game.getScreenSize().height);
        drawSnake(g);
        drawApple(g);
        g.setFont(new Font("Default", Font.BOLD, 12));

        String message = "Press <F5> to save, <F6> to load.";
        Rectangle2D messageBounds = g.getFontMetrics().getStringBounds(message, g); //g.getFontMetrics().getStringBounds - ��������� �������� ������ �������� ������ � ��������
        int messageWidth = (int)(messageBounds.getWidth());
        int messageHeight = (int)(messageBounds.getHeight());

        g.drawString(message,15, 10);

        if (paused){
            g.setFont(new Font("Default", Font.BOLD, 60));
            g.setColor(Color.white);
            message = "Pause";
            messageBounds = g.getFontMetrics().getStringBounds(message, g); //g.getFontMetrics().getStringBounds - ��������� �������� ������ �������� ������ � ��������
            messageWidth = (int)(messageBounds.getWidth());
            messageHeight = (int)(messageBounds.getHeight());
            g.drawString(message,
                    game.getScreenSize().width / 2 - messageWidth / 2,
                    game.getScreenSize().height / 2 - messageHeight / 2
            );
        }

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
        Color c = new Color(13,111, 28);
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

    //метод, который проверяет, пуста ли клетка для отрисовки яблока
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
                case KeyEvent.VK_F5:
                    save();
                    break;
                case KeyEvent.VK_F6:
                    load();
                    break;
                case KeyEvent.VK_SPACE:
                    if (paused)
                        paused = false;
                    else
                        paused = true;
                    break;
            }
        }
    }

    //метод, проверяющий не закончилась ли игра (победой или проигрышем - не важно)
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

    private void save(){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("save.dat"));
            out.writeObject(snake);
            out.writeObject(apple);
            out.writeObject(snakeMoveDelay);
            out.writeObject(delay);
            out.writeObject(appleCount);
            out.writeObject(stepsCount);
            out.writeObject(mlSeconds);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load(){
        try {
            ObjectInputStream in =  new ObjectInputStream(new FileInputStream("save.dat"));
            game.setScene(new MainScence(this.game,
                    this.panel,
                    (Snake)in.readObject(),
                    (Apple)in.readObject(),
                    (Delay)in.readObject(),
                    (int)in.readObject(),
                    (int)in.readObject(),
                    (int)in.readObject(),
                    (int)in.readObject()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
