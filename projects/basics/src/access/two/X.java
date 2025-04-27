package access.two;

import access.one.C; // ❌ The type access.one.C is not visible
import inheritance.animals.Animal;

public class X {

    public void test1() {
        C c = new C(); // ❌ The type access.one.C is not visible
    }

    public void test2() {
        Animal a = new Animal();
        // a.packagePrivateMethod(); // ❌ The method from the type A is not visible!
    }
}
