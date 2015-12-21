package com.game.java.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Елена Мирошниченко on 20.12.2015.
 */
public class SidePanel extends JPanel implements ActionListener {
    JLabel labelApple;
    JLabel labelSteps;
    JLabel labelTime;
    JRadioButton buttonblue;
    JRadioButton buttongreen;
    JRadioButton buttonblack;
    ButtonGroup group;
    Color color = Color.BLUE;

    public SidePanel(){
        super();
        setLayout(new GridLayout(10,1));
        add(new Label("Apples"));
        labelApple = new JLabel("0");
        add(labelApple);
        add(new Label("Steps"));
        labelSteps = new JLabel("0");
        add(labelSteps);
        add(new Label("Time"));
        labelTime = new JLabel("0");
        add(labelTime);

        add(new Label("Snake color"));

        buttonblack= new JRadioButton("black");
        buttongreen= new JRadioButton("green");
        buttonblue= new JRadioButton("blue");


        add(buttonblack);
        add(buttongreen);
        add(buttonblue);


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

    }
    public void setData(String time,int steps, int apple){
        labelTime.setText(""+time);
        labelSteps.setText(""+steps);
        labelApple.setText(""+apple);
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
