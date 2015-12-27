//меню уровней

package com.game.java.snake;

/**
 * Created by Helen Miroshnichenko on 18.12.2015.
 */

import javafx.scene.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class ModeScene extends Scence {
    SidePanel panel;
    Color selectedColor;
    Color textColor;
    public ModeScene(Game game,SidePanel panel) {
        super(game);
        selectedColor = Color.RED;
        textColor = Color.WHITE;
        this.panel = panel;
    }

    @Override
    public void update(long nanosPassed) {
        for (KeyEvent event : game.getInput().getKeyPressedEvents()) {
            if (event.getKeyCode() == KeyEvent.VK_1) {
                panel.setData("0s", 0, 0);
                game.setScene(new MainScence(game, panel, 400));
            }
            if (event.getKeyCode() == KeyEvent.VK_2) {
                panel.setData("0s", 0, 0);
                game.setScene(new MainScence(game, panel, 200));
            }
            if (event.getKeyCode() == KeyEvent.VK_3) {
                panel.setData("0s", 0, 0);
                game.setScene(new MainScence(game, panel, 100));
            }

        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.green);
        g.fillRect(0, 0, game.getScreenSize().width, game.getScreenSize().height);

        g.setFont(new Font("Default", Font.BOLD, 40));
        g.setColor(textColor);


        String Title = "Snake the Game";
        Rectangle2D messageBounds = g.getFontMetrics().getStringBounds(Title, g);
        int messageWidth = (int)(messageBounds.getWidth());
        int messageHeight = (int)(messageBounds.getHeight());
        g.drawString(Title,
                game.getScreenSize().width / 2 - messageWidth / 2,
                game.getScreenSize().height / 4 - messageHeight / 2
        );

        messageBounds = g.getFontMetrics().getStringBounds("1. Easy", g);
        messageWidth = (int)(messageBounds.getWidth());
        messageHeight = (int)(messageBounds.getHeight());
        g.setFont(new Font("Default", Font.BOLD, 32));
        g.setColor(textColor);
        g.drawString("1. Easy",
                game.getScreenSize().width / 2 - messageWidth / 2 - 5,
                game.getScreenSize().height / 2 - messageHeight / 2
        );

        messageBounds = g.getFontMetrics().getStringBounds("2. Normal", g);
        messageWidth = (int)(messageBounds.getWidth());
        messageHeight = (int)(messageBounds.getHeight());
        g.setFont(new Font("Default", Font.BOLD, 32));
        g.setColor(textColor);
        g.drawString("2. Normal",
                game.getScreenSize().width / 2 - messageWidth / 2 ,
                game.getScreenSize().height / 2 + 15
        );

        messageBounds = g.getFontMetrics().getStringBounds("3. Hard", g);
        messageWidth = (int)(messageBounds.getWidth());
        messageHeight = (int)(messageBounds.getHeight());
        g.setFont(new Font("Default", Font.BOLD, 32));
        g.setColor(textColor);
        g.drawString("3. Hard.",
                game.getScreenSize().width / 2 - messageWidth / 2 - 20,
                game.getScreenSize().height / 2 + 52
        );
    }


}

