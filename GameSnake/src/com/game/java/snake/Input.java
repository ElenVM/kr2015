//слушатель кнопок
package com.game.java.snake;

/**
 * Created by Helen  Miroshnichenko on 15.12.2015.
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collection;

public class Input implements KeyListener {
    private final Collection<KeyEvent> keyPressedEvents;    //пользователь нажал какую-то кнопку
    private final Collection<KeyEvent> keyReleasedEvents;   //пользователь отпустил какую-то кнопку

    public Input() {
        keyPressedEvents = new ArrayList<KeyEvent>();
        keyReleasedEvents = new ArrayList<KeyEvent>();
    }

    @Override
    public void keyTyped(KeyEvent event) {
    }

    @Override
    public synchronized void keyPressed(KeyEvent event) {   //synchronized - гарантирует, что метод будет использоваться только одним потоком в один момент времени
        keyPressedEvents.add(event);
    }

    public synchronized Collection<KeyEvent> getKeyPressedEvents() {
        Collection<KeyEvent> events = new ArrayList<KeyEvent>(keyPressedEvents);
        keyPressedEvents.clear();
        return events;
    }

    @Override
    public synchronized void keyReleased(KeyEvent event) {
        keyReleasedEvents.add(event);
    }

    public synchronized Collection<KeyEvent> getKeyReleasedEvents() {
        Collection<KeyEvent> events = new ArrayList<KeyEvent>(keyReleasedEvents);
        keyReleasedEvents.clear();
        return events;
    }
}
