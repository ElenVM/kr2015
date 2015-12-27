//направления змейки

package com.game.java.snake;

/**
 * Created by Helen  Miroshnichenko on 16.12.2015.
 */
public enum  Direction {
    UP,
    RIGHT,
    DOWN,
    LEFT;

    public int deltaX() {   //deltaX, deltaY - возвращают на сколько должна измениться координата при текущем направлении.
        switch (this) {
            case LEFT:
                return -1;
            case RIGHT:
                return 1;
            default:
                return 0;
        }
    }

    public int deltaY() {
        switch (this) {
            case UP:
                return 1;
            case DOWN:
                return -1;
            default:
                return 0;
        }
    }
}
