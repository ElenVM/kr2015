package com.game.java.snake;

import java.awt.*;

/**
 * Created by Елена Мирошниченко on 15.12.2015.
 */
public class MainScene extends Scence {
    public MainScene(Game game) {
        super(game);
    }

    @Override
    public void update(long nanosPassed) {

    }

    @Override
    public void draw(Graphics2D g) {
        g.setFont(new Font("Default", Font.BOLD, 30));
        g.drawString("It Works!", 64, 64);
    }
}
