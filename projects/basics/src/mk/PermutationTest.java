package mk;

public class PermutationTest {

    void test() {
        // range a: 10-11
        // range b: 20-21
        // range c: 30-31

        for (int a = 10; a < 12; a++) {
            for (int b = 20; b < 22; b++) {
                for (int c = 30; c < 32; c++) {
                    System.out.printf("(%d, %d, %d)\n", a, b, c);
                }
            }
        }
    }

    void precedenceTest() {
        System.out.println("Precedence Test");
        boolean[] options = { true, false };

        for (var a : options) {
            for (var b : options) {
                for (var c : options) {
                    boolean cond1 = a & b | c;
                    boolean cond2 = a | b & c;
                    System.out.printf("(%b, %b, %b) = %b, %b)\n", a, b, c, cond1, cond2);
                }
            }
        }
    }

    public static void main(String[] args) {

        PermutationTest pt = new PermutationTest();
        // pt.test();
        pt.precedenceTest();

    }
}
