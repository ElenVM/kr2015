package com.game.java.snake;

/**
 * Created by Елена Мирошниченко on 18.12.2015.
 */
public class Delay {
    private long delayNanos;
    private long passedNanos;

    public Delay(long delayMillis) {
        this.delayNanos = TimeConverter.millisToNanos(delayMillis);
    }

    public boolean updateAndCheck(long deltaNanos) {
        passedNanos += deltaNanos;
        if (passedNanos > delayNanos) {
            passedNanos = 0;
            return true;
        } else {
            return false;
        }
    }

}
