//пока время не станет нужной нам зедержки, в этом случае переменная обнуляется,
// а мы выполняем нужное нам действие.
package com.game.java.snake;

import java.io.Serializable;

/**
 * Created by Helen  Miroshnichenko on 18.12.2015.
 */
public class Delay implements Serializable {
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
