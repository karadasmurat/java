package access.two;

import access.one.A;

public class SpecialA extends A { // extend a class from another package

    public void test() {

        publicMethodA(); // ✅ The method is public, so it is visible
        packagePrivateMethodA(); // ❌ The method from the type A is not visible!
    }

}
