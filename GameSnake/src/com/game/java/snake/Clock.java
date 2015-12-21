package com.game.java.snake;

/**
 * Created by Елена Мирошниченко on 20.12.2015.
 */
public class Clock {

    public static String  getTime(int mlSec){
        String str="";
        int seconds = mlSec/1000;
        str+=seconds+"s";
        return str;
    }
}
