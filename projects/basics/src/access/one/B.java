package access.one;

import access.one.C;

public class B {

    public void publicMethodB() { // public method
        System.out.println("Public method in B");
    }

    // Package private method - only for package friends (default access)
    void packagePrivateMethodB() {
        System.out.println("Package-private method in B");
    }

    public void test() {
        A a = new A(); // ✅ Allowed: B is in the same package as A
        a.packagePrivateMethodA(); // ✅ Allowed: B is in the same package as A

        C c = new C(); // ✅ Allowed: B is in the same package as C
        // c.packagePrivateMethodC(); // ✅ Allowed: B is in the same package as C
    }
}
