package basics;

import java.util.logging.Logger;

public class App {

    // getClass() is an instance method. It belongs to a specific object (this).
    // You cannot call getClass() inside a static variable declaration.
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        System.out.println("Hello, there!");

        logger.info("mvn-hello says hi!");
    }
}
