package mk;

public class FinalTest {

    // static final int MULTIPLIER; // ERR field may not have been initialized.

    // "blank final" variable
    // it's declared as final but not initialized immediately.
    private final int finalVar;

    public FinalTest(int initialValue) {

        // final variable initialized within the constructor
        this.finalVar = initialValue;
    }

    // Provide read-only access to the final variable
    public int getFinalVar() {
        return this.finalVar;
    }

    public static void main(String[] args) {
        FinalTest ft1 = new FinalTest(1);
        FinalTest ft2 = new FinalTest(2);

        System.out.println(ft1.getFinalVar()); // 1
        System.out.println(ft2.getFinalVar()); // 2

    }
}
