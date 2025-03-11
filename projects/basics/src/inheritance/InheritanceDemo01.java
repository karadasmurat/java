package inheritance;

class Vehicle {

    public void move() {
        System.out.println("VEHICLE is moving");
    }
}

class Scooter extends Vehicle {
    // Does NOT override move(), inherits from Vehicle
}

class Bus extends Vehicle {
    @Override
    public void move() {
        System.out.println("BUS is moving");
    }
}

public class InheritanceDemo01 {

    public static void main(String[] args) {

        Scooter scooter = new Scooter(); // scooter is a Scooter ref
        scooter.move(); // Scooter inherits move(): call Vehicle.move()

        Bus bus = new Bus(); // bus is a Bus ref
        bus.move(); // call Bus.move()

        Vehicle polyBus = new Bus(); // polyBus is a Vehicle ref
        polyBus.move(); // Bus overrides move(): call Bus.move()
    }
}
