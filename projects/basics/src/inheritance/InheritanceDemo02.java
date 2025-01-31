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

public class InheritanceDemo02 {

    public static void main(String[] args) {
        Bus bus = new Bus(); // bus is a Bus instance
        bus.move(); // Bus overrides move(): call the method from Bus
    }
}
