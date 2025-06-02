package tmp;

interface Greeting {

    String GREETING_PREFIX = "Hello, "; // public static final by default

    void greet(String name);
}

public class App {

    // static methods cannot directly access instance members!
    public static void main(String[] args) {

        final var k = 6.02;

    }
}