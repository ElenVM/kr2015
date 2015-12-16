/**
 * Created by Елена Мирошниченко on 15.12.2015.
 */
package com.game.java.snake;

import java.awt.*;

public abstract class Scence {
    protected final Game game;

    public Scence(Game game) {
        this.game = game;
    }

    public abstract void update(long nanosPassed);

    public abstract void draw(Graphics2D g);
}