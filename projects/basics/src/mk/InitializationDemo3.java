package mk;

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

public class InitializationDemo3 {

    static int y;

    static {
        System.out.println("Static {}: ID3.y");
        y = 10;
    }

    // Reference as a static variable
    static A a = new A();

    public InitializationDemo3() {
        System.out.println("InitializationDemo3()");
    }

    public static void main(String[] args) { // Load ID3
        // int tmp = A.x; // Load A
        // A a = new A(); // Load A, A()
    }

}
