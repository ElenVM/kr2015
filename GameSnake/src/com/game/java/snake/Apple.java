//размеры яблока

package com.game.java.snake;


import java.io.Serializable;

/**
 * Created by Helen  Miroshnichenko on 16.12.2015.
 */
public class Apple implements Serializable{
    private int x;
    private int y;

    public Apple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
