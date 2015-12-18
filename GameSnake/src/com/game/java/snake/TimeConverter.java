//��������� �������

package com.game.java.snake;

/**
 * Created by ����� ������������ on 18.12.2015.
 */
public class TimeConverter {
    private static final int NANOSECONDS_IN_MILLISECOND = 1000000;

    public static long nanosToMillis(long nanos) {
        return nanos / NANOSECONDS_IN_MILLISECOND;
    }

    public static long millisToNanos(long millis) {
        return millis * NANOSECONDS_IN_MILLISECOND;
    }
}
