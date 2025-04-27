package access.one;

import access.one.C;

public class B {

    public void publicMethodB() { // public method
        System.out.println("Public method in B");
    }

    void packagePrivateMethodB() { // Package-private method (default)
        System.out.println("Package-private method in B");
    }

    public void test1() {
        C c = new C(); // ✅ Allowed: B is in the same package as C
        c.sayHi();
    }

    public void test() {
        A a = new A();
        a.packagePrivateMethod(); // ✅ Allowed: B is in the same package as A
    }
}
