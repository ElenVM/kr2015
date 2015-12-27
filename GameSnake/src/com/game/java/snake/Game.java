package com.game.java.snake;

import java.awt.*;

/**
 * Created by Helen  Miroshnichenko on 15.12.2015.
 */
public interface Game {
    void start();
    void pause();
    Dimension getScreenSize();
    Input getInput();   //получаем объект, который хранит все пользовательские манипул€ции с контроллерами
    void setScene(Scence scene);    //мен€ет текущую сцену
    void setData(double time,int steps, int apple);
}
