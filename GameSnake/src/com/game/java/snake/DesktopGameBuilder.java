package com.game.java.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Елена Мирошниченко on 15.12.2015.
 */
public class DesktopGameBuilder {
    public static SidePanel panel;
    public static Game build(Dimension screenSize) {

        final CanvasGame game = new CanvasGame(screenSize);
        panel = new SidePanel();
        JFrame frame = new JFrame();
        frame.setFocusable(false);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(game,BorderLayout.CENTER);
        frame.add(panel,BorderLayout.WEST);
        frame.pack();
        frame.setVisible(true);

        game.createBufferStrategy(2);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent event) {

                game.pause();
            }
        });

        frame.requestFocus();
        game.requestFocus();
        return game;
    }

    public static SidePanel getPanel(){
        return panel;
    }
}
