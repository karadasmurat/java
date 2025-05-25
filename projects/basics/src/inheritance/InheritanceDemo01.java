package inheritance;

class Vehicle2 {

    public void move() {
        System.out.println("VEHICLE is moving");
    }
}

class Scooter extends Vehicle2 {
    // Does NOT override move(), inherits from Vehicle
}

class Bus2 extends Vehicle2 {
    @Override
    public void move() {
        System.out.println("BUS is moving");
    }
}

public class InheritanceDemo01 {

    public static void main(String[] args) {

        Scooter scooter = new Scooter(); // scooter is a Scooter ref
        scooter.move(); // Scooter inherits move(): call Vehicle.move()

        Bus2 bus = new Bus2(); // bus is a Bus ref
        bus.move(); // call Bus.move()

        Vehicle2 polyBus = new Bus2(); // polyBus is a Vehicle ref
        polyBus.move(); // Bus overrides move(): call Bus.move()
    }
}
