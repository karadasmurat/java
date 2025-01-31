package inheritance;

class Vehicle {

    public void move() {
        System.out.println("VEHICLE is moving");
    }
}

class Bus extends Vehicle {
    // Does not override eat() of parent.
}

public class InheritanceDemo00 {

    public static void main(String[] args) {
        Bus bus = new Bus(); // bus is a Bus instance
        bus.move(); // // Bus does not override move(): call the method from Vehicle
    }
}
