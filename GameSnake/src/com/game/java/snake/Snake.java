//передвижение змейки

package com.game.java.snake;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Helen Miroshnichenko on 18.12.2015.
 */

public class Snake implements Serializable {
    private List<BodyPart> body;
    private Direction direction;

    public Snake(int x, int y, Direction direction) {
        this.direction = direction;
        body = new ArrayList<BodyPart>();
        body.add(new BodyPart(x, y));
        body.add(new BodyPart(x - direction.deltaX(), y - direction.deltaY()));
        body.add(new BodyPart(x - direction.deltaX() * 2, y - direction.deltaY() * 2));
    }

    //метод передвижение змейки
    public void move() {
        moveBody(); //тело
        moveHead(); //голова
    }

    private void moveBody() {
        for (int i = body.size() - 1; i > 0; i--) {
            BodyPart current = body.get(i);
            BodyPart previous = body.get(i - 1);
            current.setX(previous.getX());
            current.setY(previous.getY());
        }
    }

    private void moveHead() {
        head().setX(head().getX() + direction.deltaX());
        head().setY(head().getY() + direction.deltaY());
    }

    public BodyPart head() {
        return body.get(0);
    }

    public List<BodyPart> getBody() {
        return body;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
