package domain;

import interfaces.Flyable;

public class Bird implements Flyable {

    @Override
    // Moveable interface method
    public void move() {
        System.out.println("Bird is moving.");
    }

    @Override
    // Moveable interface method
    public void stop() {
        System.out.println("Bird stops moving.");
    }

    @Override
    // Flyable interface method
    public void fly() {
        System.out.println("Bird is flying.");
    }

    @Override
    // Flyable interface method
    public void land() {
        System.out.println("Bird is landing.");
    }

}
