package access.two;

import access.one.A;

// SpecialA is a subclass of A, but it is in a different package.
// It can access public and protected methods of A, but not package-private methods.
public class SpecialA extends A {

    public void publicGatewayToParentsProtectedMethod() {
        protectedMethodA(); // ✅ Can access protected method from parent class A
    }

    public void test() {

        publicMethodA(); // ✅ The method is public, so it is visible

        // This class is in a different package than its parent A,
        // so it can only access public and protected methods
        // packagePrivateMethodA(); // ❌ The method from the type A is not visible!
    }

}
