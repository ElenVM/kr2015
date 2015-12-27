//тело змейки
package com.game.java.snake;

import java.io.Serializable;

/**
 * Created by Helen  Miroshnichenko on 16.12.2015.
 */
public class BodyPart implements Serializable {
    private int x;
    private int y;

    public BodyPart(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {

        return x;
    }

    public void setX(int x) {

        this.x = x;
    }

    public int getY() {

        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
