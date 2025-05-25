package access.one;

public class A {

    // public method - visible to all
    public void publicMethodA() {
        System.out.println("Public method in A");
    }

    // Protected method - visible to subclasses and package friends
    public void protectedMethodA() {
        System.out.println("Protected method in A");
    }

    // Package private method - only for package friends (default access)
    void packagePrivateMethodA() {
        System.out.println("Package-private method in A");
    }
}
