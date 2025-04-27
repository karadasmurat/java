package access.one;

public class A {

    public void publicMethodA() { // public method
        System.out.println("Public method in A");
    }

    // Package private method - only for package friends (default access)
    void packagePrivateMethodA() {
        System.out.println("Package-private method in A");
    }
}
