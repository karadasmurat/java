package mk;

public class OverloadTest {
    public void overloadedOperation(String a, int b) {
        System.out.println(a + b);
    }

    public void overloadedOperation(int a, String b) {
        System.out.println(a + b);
    }

    public void f(short s) {
        System.out.println("short!");
    }

    public void f(int i) {
        System.out.println("int!");
    }

    public void f(long s) {
        System.out.println("long!");
    }
}
