package access.one;

import access.one.A;

// SpecialAOne is a subclass of A, and it is in the same package.
// It can access all, but private methods of A.
public class SpecialAOne extends A {

    public void publicGatewayToParentsProtectedMethod() {
        protectedMethodA(); // ✅ Can access protected method from parent class A
    }

    public void test() {

        publicMethodA(); // ✅

        protectedMethodA(); // ✅

        packagePrivateMethodA(); // ✅

        // privateMethodA(); // ❌ CompileERR: Not visible
    }

}
