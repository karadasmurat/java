package initialization;

class Shape {
    static {
        System.out.println("Class Shape: Static initializor");
    }

    Shape() {
        System.out.println("Shape(): Construct Shape instance");
    }
}

class Triangle extends Shape {
    static {
        System.out.println("Class Triangle: Static initializor");
    }

    Triangle() {
        System.out.println("Triangle(): Construct Triangle instance");
    }
}

public class InitializationInheritance {

    static {
        System.out.println("Class InitializationInheritance: Static initializor");
    }

    public static void main(String[] args) { // Load class

        Triangle triangle = new Triangle();

    }

}
