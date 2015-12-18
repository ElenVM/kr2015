//точка входа в игру
package com.game.java.snake;

import java.awt.*;

import static com.game.java.snake.Constant.*;

/**
 * Created by Елена Мирошниченко on 15.12.2015.
 */
public class DesktopLauncher {
    public static void main(String[] args) {

        int screenWidth = WORLD_WIDTH * CELL_SIZE;
        int screenHeight = WORLD_HEIGHT * CELL_SIZE;

        Dimension screenSize = new Dimension(screenWidth, screenHeight);

        Game game = DesktopGameBuilder.build(new Dimension(640, 480));
        game.setScene(new MainScene(game));
        game.start();
    }
}