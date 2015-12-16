//����������� ������

package com.game.java.snake;

/**
 * Created by ����� ������������ on 16.12.2015.
 */
public enum  Direction {
    UP,
    RIGHT,
    DOWN,
    LEFT;

    public int deltaX() {
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
