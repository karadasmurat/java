package access.two;

import access.one.A;

// SpecialA is a subclass of A, but it is in a different package.
// It can access public and protected methods of A through inheritance or through an instance of itself
public class SpecialA2 extends A {

    public void publicGatewayToParentsProtectedMethod() {
        protectedMethodA(); // ✅ Can access protected method from parent class A
    }

    // SpecialA2 defines an independent protected method
    void protectedMethodA2() {
        System.out.println("protected");
    }

    // SpecialA2 inherits public and protected methods from A,
    // meaning it can use them as if they were defined in the subclass itself.
    public void inheritedTest() {

        publicMethodA(); // ✅ public parent method is inherited

        protectedMethodA(); // ✅ protected parent method is inherited

        // This class is in a different package than its parent A,
        // so it can only access public and protected methods
        // packagePrivateMethodA(); // ❌ CompileERR: Not visible

        // privateMethodA(); // ❌ CompileERR: Not visible
    }

    public void referencetest() {

        // an instance of parent
        A a = new A();

        a.publicMethodA();
        // a.protectedMethodA();// ❌ CompileERR: Not visible
        // a.packagePrivateMethodA();// ❌ CompileERR: Not visible
        // a.privateMethodA(); // ❌ CompileERR: Not visible

        // an instance of itself
        SpecialA2 satwo = new SpecialA2();
        satwo.publicMethodA(); // ✅
        satwo.protectedMethodA(); // ✅ can access public and protected methods of A
                                  // through inheritance or through an instance of itself
        // satwo.packagePrivateMethodA(); // ❌ CompileERR: Not visible
        // satwo.privateMethodA();// ❌ CompileERR: Not visible
    }

}
