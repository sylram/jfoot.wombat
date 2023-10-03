package com.github.curriculeon.jfoot;

import static com.github.curriculeon.jfoot.Direction.*;

/**
 * Wombat. A Wombat moves forward until it hits the edge of the world, at
 * which point it turns left. If a wombat finds a leaf, it eats it.
 *
 * @author Michael Kölling
 * @version 2.0
 */
public class Wombat extends Herbivore {

    int counter = 0;
    public Wombat() {
        setImage("wombat.png");
    }

    public void act() {
        while (counter <= 10) {
            if (this.foundLeaf()) {
                this.eatLeaf();
            } else if (this.canMove()) {
                this.move();
            } else {
                if (counter % 2 == 0) {
                    this.turnLeft();
                    this.move();
                    this.turnLeft();
                } else {
                    this.turnRight();
                    this.move();
                    this.turnRight();
                }
                counter++;
            }
        }
    }

    public void turnLeft() {
        if (this.getDirection() == EAST) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == WEST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == NORTH) {
            this.setDirection(WEST);
        } else {
            this.setDirection(EAST);
        }
    }

    public void turnRight() {
        if (this.getDirection() == EAST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == WEST) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == NORTH) {
            this.setDirection(EAST);
        } else {
            this.setDirection(WEST);
        }
    }
}
