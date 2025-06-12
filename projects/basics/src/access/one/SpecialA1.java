package access.one;

import access.one.A;

// SpecialAOne is a subclass of A, and it is in the same package.
// It can access all, but private methods of A.
public class SpecialA1 extends A {

    public void publicGatewayToParentsProtectedMethod() {
        protectedMethodA(); // ✅ Can access protected method from parent class A
    }

    // SpecialAOne inherits all non-private methods from A,
    // meaning it can use them as if they were defined in the subclass itself.
    public void inheritedTest() {

        publicMethodA(); // ✅

        protectedMethodA(); // ✅

        packagePrivateMethodA(); // ✅

        // privateMethodA(); // ❌ CompileERR: Not visible
    }

    public void referencetest() {

        A a = new A(); // parent in the same package

        a.publicMethodA();
        a.protectedMethodA();
        a.packagePrivateMethodA();
        // a.privateMethodA(); // ❌ CompileERR: Not visible
    }

}
