package mk;

public class ShadowTest {
    int x = 10; // Instance variable

    public void myMethod() {

        int x = 20; // Local variable shadows the instance variable
        
        System.out.println("Inner x: " + x); // Prints 20 (inner x)

        System.out.println("Outer x: " + this.x); // Accessing the instance variable explicitly
    }

    public static void main(String[] args) {
        ShadowTest test = new ShadowTest();
        test.myMethod();
    }
}
