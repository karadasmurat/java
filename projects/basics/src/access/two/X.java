package access.two;

import access.one.A;

public class X {

    public void test() {
        A a = new A();
        // a.packagePrivateMethod(); // ❌ The method from the type A is not visible!
    }
}
