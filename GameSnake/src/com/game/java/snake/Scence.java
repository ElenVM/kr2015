package com.game.java.snake;

import java.awt.*;

/**
 * Created by Елена Мирошниченко on 15.12.2015.
 */


public abstract class Scence {
    protected final Game game;

    public Scence(Game game) {
        this.game = game;
    }

    public abstract void update(long nanosPassed);

    public abstract void draw(Graphics2D g);
}