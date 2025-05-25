package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import inheritance.animals.domestic.Dog;

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

    public void tmp() {

        try {

            System.out.println("try block begins");
            throw new IOException("Thrown from try");

        } catch (IOException e) {

            System.out.println("First catch block begins");
            throw new RuntimeException("Thrown from catch"); // NOT caught by the next catch, new throw is not in the
                                                             // try block directly.

        } catch (Exception e) {
            System.out.println("Second catch block begins");

        }

        System.out.println("* Life goes on!"); // Unreachable code

    }

    public static void main(String[] args) {

        ExceptionDemo et = new ExceptionDemo();

        // et.workOnNullRef();
        // et.doThrowUnchecked();
        // et.catchAndThrow();
        // et.rollBack();
        et.tmp();

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