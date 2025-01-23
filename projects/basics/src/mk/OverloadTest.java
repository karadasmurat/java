package mk;

public class OverloadTest {
    public void overloadedOperation(String a, int b) {
        System.out.println(a + b);
    }

    public void overloadedOperation(int a, String b) {
        System.out.println(a + b);
    }
}
