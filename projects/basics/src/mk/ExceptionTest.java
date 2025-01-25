package mk;

import java.util.ArrayList;
import java.util.NoSuchElementException;

class MKException extends Exception {

    /**
     * Constructs a {@code MKException} with no detail message.
     */
    public MKException() {
        super();
    }

    /**
     * Constructs a {@code MKException} with the specified detail message.
     *
     * @param s the detail message.
     */
    public MKException(String s) {
        super(s);
    }
}

public class ExceptionTest {

    public void workOnNullRef() {
        // Create an empty ArrayList of Integers
        ArrayList<Integer> myList = new ArrayList<>();

        System.out.println("Length: " + myList.getFirst()); // NoSuchElementException: Runtime (Unchecked)
    }

    public void doThrowUnchecked() {
        throw new ArithmeticException();
    }

    public void doThrowMK() throws MKException {
        throw new MKException("Houston ?!");
    }

    public static void main(String[] args) {

        ExceptionTest et = new ExceptionTest();

        // et.workOnNullRef();
        // et.doThrowUnchecked();

        System.out.println("Life goes on!");

        int x = 40;
        if (x < 60) {
            int bonus = 5;
            System.out.println("Fail");
        }

        for (int m = 0; m < 5; m++) {
            int k = m;
            System.out.println(k);
        }

    }

}
