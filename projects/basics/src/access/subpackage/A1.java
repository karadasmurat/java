package access.subpackage;

public class A1 {
    private A2 x;  // A2 is package-private, so it is accessible in the same package
                   // Since A2 is not public, it is NOT accessible outside the package
    

    public A2 getX() {
        return x;
    }
}
