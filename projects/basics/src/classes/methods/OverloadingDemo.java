package classes.methods;

public class OverloadingDemo {

    void overloaded(Integer val) {
        System.out.println("Integers only!");
    }

    void overloaded(long val) {
        System.out.println("long primitives only!");
    }

    public static void main(String[] args) {
        OverloadingDemo od = new OverloadingDemo();

        int i = 1;

        //  the method is given an int argument
        // 
        od.overloaded(i); // long primitives only!

    }
}
