package inheritance;

class Vehicle {

    public void move() {
        System.out.println("VEHICLE is moving");
    }
}

class Bus extends Vehicle {
    @Override
    public void move() {
        System.out.println("BUS is moving");
    }
}

public class InheritanceDemo01 {

    public static void main(String[] args) {
        Bus bus = new Bus(); // bus is a Bus instance
        bus.move(); // Bus overrides move(): call the method from Bus

        Vehicle polyBus = new Bus(); // polyBus is a Vehicle instance
        polyBus.move(); // Bus overrides move(): call the method from Bus
    }
}
