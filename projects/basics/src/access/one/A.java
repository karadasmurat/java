package access.one;

public class A {

    // public method - visible to all
    public void publicMethodA() {
        System.out.println("A.publicMethodA()");

        privateMethodA(); // Can call private method within the same class
    }

    // Protected method - visible to package friends + subclasses in other packages
    protected void protectedMethodA() {
        System.out.println("A.protectedMethodA()");
    }

    // Package private method - only for package friends (default access)
    void packagePrivateMethodA() {
        System.out.println("A.packagePrivateMethodA()");
    }

    // Private method - only visible within this class
    private void privateMethodA() {
        System.out.println("A.privateMethodA");
    }
}
