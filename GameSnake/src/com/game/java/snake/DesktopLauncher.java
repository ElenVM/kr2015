//точка входа в игру
package com.game.java.snake;

import java.awt.*;

/**
 * Created by Елена Мирошниченко on 15.12.2015.
 */
public class DesktopLauncher {
    public static void main(String[] args) {
        Game game = DesktopGameBuilder.build(new Dimension(640, 480));
        game.setScene(new MainScene(game));
        game.start();
    }
}