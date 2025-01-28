package initialization;

public class InitializationDemo0 {

    private String name; // instance variable decleration
    private int value; // instance variable decleration

    // instance initializer block
    // a convenient way to initialize fields before the constructor is called.
    {
        System.out.println("Instance Initializer");
    }

    // Constructor is executed after the instance initializer block!
    public InitializationDemo0() {
        System.out.println("Constructor");
        System.out.println("field already initialized to default!: " + value); // field already initialized!: 0
        System.out.println("field already initialized to default!: " + name); // field already initialized!: null
    }

    public static void main(String[] args) {
        InitializationDemo0 id = new InitializationDemo0();
    }
}
