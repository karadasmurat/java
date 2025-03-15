package access.two;

import access.one.C; // ❌ The type access.one.C is not visible

public class X {

    public void test1() {
        Cat c = new Cat(); // ERROR: The type access.one.C is not visible
    }

    public void test2() {
        Animal a = new Animal();
        // a.packagePrivateMethod(); // ❌ The method from the type A is not visible!
    }
}
