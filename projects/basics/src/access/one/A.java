package access.one;

public class A {

    public void publicMethodA() { // public method
        System.out.println("Public method in A");
    }

    void packagePrivateMethodA() { // Package-private method (default)
        System.out.println("Package-private method in A");
    }
}
