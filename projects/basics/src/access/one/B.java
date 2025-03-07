package access.one;

public class B {
    public void test() {
        A a = new A();
        a.packagePrivateMethod(); // ✅ Allowed: B is in the same package as A
    }
}
