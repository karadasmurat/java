package initialization;

public class InitializationDemo2 {
    static int s;

    static {
        s = 11;
        System.out.println("Static initialization block executed");
    }

    private int x;

    {
        x = 22;
        System.out.println("Instance initialization block executed");
    }

    public InitializationDemo2() {
        System.out.println("Constructor executed");
    }

    public static void main(String[] args) {
        // a. Empty main function

        // b. 3 instances
        InitializationDemo2 obj1 = new InitializationDemo2();
        InitializationDemo2 obj2 = new InitializationDemo2();
        InitializationDemo2 obj3 = new InitializationDemo2();
    }
}
