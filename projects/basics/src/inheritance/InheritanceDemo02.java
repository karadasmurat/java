package inheritance;

import domain.Circle;
import domain.Rectangle;
import domain.Shape2D;

class Vehicle {

    public Shape2D doSomething(Shape2D s) {
        System.out.println("using a Shape2D parameter");
        return s;
    }
}

class Bus extends Vehicle {

    // covariant return type
    // The return type is a subclass of the return type of the overridden (parent) method
    // The callers of parent are expecting a Shape2D, so the child can return a Rectangle
    @Override
    public Rectangle doSomething(Shape2D s) {
        System.out.println("VEHICLE is moving");
        return new Rectangle(1, 2);
    }

    // No overloading with different parameter types
    // The callers of parent method can send a Shape2D, Circle, or Rectangle as a parameter
    // So, the child must also accept a Shape2D, Circle, or Rectangle
    // @Override
    // public Rectangle doSomething(Rectangle s) { // ❌ DOES NOT COMPILE
    //     System.out.println("VEHICLE is moving");
    //     return new Rectangle(1, 2);
    // }
}

public class InheritanceDemo02 {

    public static void main(String[] args) {
        
        Vehicle vehicle = new Bus();
        Shape2D shape = new Circle(1);
        Shape2D result = vehicle.doSomething(shape);
    }
}
