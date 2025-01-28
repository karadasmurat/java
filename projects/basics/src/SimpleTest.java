// package domain; // package must be first non-comment

// import java.util.*; // import must come after package

import java.io.File;

class Simple { // then comes the class
    double width; // fields and methods can go in either order

    public double getArea() {
        return width * height;
    }

    double height; // another field – they don't need to be together
}

public class SimpleTest {

    public static void main(String[] args) {
        Simple simple = new Simple();
        System.out.println(simple.getArea());

    }

}