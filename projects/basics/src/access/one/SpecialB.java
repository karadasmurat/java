package access.one;

public class SpecialB extends B { // extend a class from the same package

    public void test() {

        publicMethodB(); // ✅ The method is public, so it is visible
        packagePrivateMethodB(); // ✅ parent is in the same package, visible!
    }

}
