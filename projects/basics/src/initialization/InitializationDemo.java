package initialization;

public class InitializationDemo {
    static int s;
    static {
        System.out.println("Static initialization block for s.");
        // complex logic
        try {
            // Load the JDBC driver
            // Establish a connection to the database
            s = 2;
        } catch (Exception e) {
            // Handle the exception appropriately (e.g., log the error, exit the program)
            System.err.println("Error establishing database connection: " + e.getMessage());
        }

    }
    private int x = initX(); // initialize an instance variable by calling a method.
    private int y = x > 5 ? 50 : 1;

    private int coeff;

    {
        System.out.println("Initialization block for coeff.");
        coeff = 11;
    }

    private int initX() {
        return 10;
    }

    public int multiply() {
        return x * y * s;
    }

    public static void main(String[] args) {
        // 1. nothing in the static main.
        // class loads, static initialization done.
        // no objects created - no initialization or constructors.

        // InitializationDemo id = new InitializationDemo();
        // System.out.println(id.multiply());
    }
}
