//меню боковое в игре

package com.game.java.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 * Created by Helen Miroshnichenko on 22.12.2015.
 */
public class Menu extends JPanel implements ActionListener {
    JButton start;
    JButton exit;

    JRadioButton buttonblue;
    JRadioButton buttongreen;
    JRadioButton buttonblack;
    ButtonGroup group;
    Color color = Color.BLUE;
    ActionListener listener;

    public Menu(ActionListener listener){
        super();
        this.listener = listener;
        setLayout(new GridLayout(4,1));


        exit.addActionListener(listener);
        start.addActionListener(listener);


        buttonblack= new JRadioButton("black");
        buttongreen= new JRadioButton("green");
        buttonblue= new JRadioButton("blue");

        buttonblack.addActionListener(this);
        buttongreen.addActionListener(this);
        buttonblue.addActionListener(this);

        group = new ButtonGroup();
        group.add(buttonblack);
        group.add(buttonblue);
        group.add(buttongreen);

        buttonblack.setActionCommand("black");
        buttongreen.setActionCommand("green");
        buttonblue.setActionCommand("blue");

        add(buttonblack);
        add(buttongreen);
        add(buttonblue);
        add(start);
        add(exit);
        setBounds(100,100,200,200);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if("green".equals(e.getActionCommand()))
            color = Color.green;
        if("blue".equals(e.getActionCommand()))
            color = Color.blue;
        if("black".equals(e.getActionCommand()))
            color = Color.black;

    }
    public Color getColor(){

        return color;
    }
}
