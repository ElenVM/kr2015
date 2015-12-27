package com.game.java.snake;

import java.awt.*;

/**
 * Created by Helen  Miroshnichenko on 15.12.2015.
 */
public interface Game {
    void start();
    void pause();
    Dimension getScreenSize();
    Input getInput();   //�������� ������, ������� ������ ��� ���������������� ����������� � �������������
    void setScene(Scence scene);    //������ ������� �����
    void setData(double time,int steps, int apple);
}
