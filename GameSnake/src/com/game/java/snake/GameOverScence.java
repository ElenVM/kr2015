package com.game.java.snake;

/**
 * Created by Елена Мирошниченко on 18.12.2015.
 */

import javafx.scene.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class GameOverScence extends Scence {
    public GameOverScence(Game game) {
        super(game);
    }

    @Override
    public void update(long nanosPassed) {
        for (KeyEvent event : game.getInput().getKeyPressedEvents()) {
            if (event.getKeyCode() == KeyEvent.VK_ENTER) {
                game.setScene(new MainScence(game));
            }
        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, game.getScreenSize().width, game.getScreenSize().height);

        g.setFont(new Font("Default", Font.BOLD, 16));
        g.setColor(Color.white);

        //String message = "Game Over\n";
        String message = "Press <Enter> to start new game ";
        Rectangle2D messageBounds = g.getFontMetrics().getStringBounds(message, g);
        int messageWidth = (int)(messageBounds.getWidth());
        int messageHeight = (int)(messageBounds.getHeight());

        g.drawString(message,
                game.getScreenSize().width / 2 - messageWidth / 2,
                game.getScreenSize().height / 2 - messageHeight / 2
        );
    }
}
