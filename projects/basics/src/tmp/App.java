package tmp;

interface Greeting {

    String GREETING_PREFIX = "Hello, "; // public static final by default

    void greet(String name);
}

public class App {

    // static methods cannot directly access instance members!
    public static void main(String[] args) {

        // declare and instantiate an anonymous class
        Greeting greeting = new Greeting() {
            @Override
            public void greet(String name) {
                System.out.println(GREETING_PREFIX + name);
            }
        };
    }
}