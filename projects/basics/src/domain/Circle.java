package domain;

public class Circle {

    private int radius;

    public Circle(int radius) { // Local variable
        this.radius = radius; // Assigns value to the instance variable
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public void doSomething(int radius) {
        System.out.println("radius:" + radius); // Local variable
        System.out.println("this.radius:" + this.radius); // Instance variable
    }

    public static void main(String[] args) {
        Circle circle = new Circle(10);
        circle.doSomething(5);

        System.out.println("Area: " + circle.getArea());
    }

}
