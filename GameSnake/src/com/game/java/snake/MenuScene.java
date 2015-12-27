/// меню при входе игры

package com.game.java.snake;

/**
 * Created by Елена Мирошниченко on 18.12.2015.
 */

import javafx.scene.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class MenuScene extends Scence {
    SidePanel panel;
    Color selectedColor;
    Color textColor;
    public MenuScene(Game game,SidePanel panel) {
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
                game.setScene(new MainScence(game, panel));
            }
            if (event.getKeyCode() == KeyEvent.VK_2) {
                panel.setData("0s", 0, 0);
                game.setScene(new ModeScene(game, panel));
            }
            if (event.getKeyCode() == KeyEvent.VK_3) {
                System.exit(0);
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

        messageBounds = g.getFontMetrics().getStringBounds("1. Start", g);
        messageWidth = (int)(messageBounds.getWidth());
        messageHeight = (int)(messageBounds.getHeight());
        g.setFont(new Font("Default", Font.BOLD, 32));
        g.setColor(textColor);
        g.drawString("1. Start",
                game.getScreenSize().width / 2 - messageWidth / 2,
                game.getScreenSize().height / 2 - messageHeight / 2
        );

        messageBounds = g.getFontMetrics().getStringBounds("2. Mode", g);
        messageWidth = (int)(messageBounds.getWidth());
        messageHeight = (int)(messageBounds.getHeight());
        g.setFont(new Font("Default", Font.BOLD, 32));
        g.setColor(textColor);
        g.drawString("2. Mode",
                game.getScreenSize().width / 2 - messageWidth / 2 - 8,
                game.getScreenSize().height / 2 + 15
        );

        messageBounds = g.getFontMetrics().getStringBounds("3. Exit", g);
        messageWidth = (int)(messageBounds.getWidth());
        messageHeight = (int)(messageBounds.getHeight());
        g.setFont(new Font("Default", Font.BOLD, 32));
        g.setColor(textColor);
        g.drawString("3. Exit.",
                game.getScreenSize().width / 2 - messageWidth / 2 - 20,
                game.getScreenSize().height / 2 + 52
        );
    }


}
