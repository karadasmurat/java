package initialization;

class A {

    static int x;

    static {
        System.out.println("Static {}: A.x");
        x = 10;
    }

    public A() {
        System.out.println("A()");
    }
}

public class InitializationDemo4 {

    // Reference as a static variable
    static A a = new A(); // runs when ID4 Class loads, which Loads A, then constructs A.

    public InitializationDemo4() {
        System.out.println("InitializationDemo4()");
    }

    public static void main(String[] args) { // Load InitializationDemo4

    }

}
