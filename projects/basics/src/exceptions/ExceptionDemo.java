package exceptions;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import inheritance.Dog;

public class ExceptionDemo {

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

    public void catchAndThrow() {

        System.out.print("a");

        try {
            System.out.print("b");
            throw new IllegalArgumentException();
        } catch (RuntimeException e) { // catch RuntimeException or any subclass of it
            System.out.print("c");
        } finally {
            System.out.print("d");
        }

        System.out.print("e");
    }

    public void rollBack() {

        Dog bob = new Dog("bob");

        try {
            bob.setName("bobi"); // successfully executed before the exception was thrown
            doThrowMK(); // throw an Exception
        } catch (Exception e) {
            System.out.println("Exception! Rolling back..");
            bob.setName("bob");
        }

        System.out.println(bob);
    }

    public static void main(String[] args) {

        ExceptionDemo et = new ExceptionDemo();

        // et.workOnNullRef();
        // et.doThrowUnchecked();

        // et.catchAndThrow();

        et.rollBack();

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
