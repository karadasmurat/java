package statics;



import java.util.Arrays;
import static java.util.Arrays.asList;

class Counter {
    private static int cnt;

    public Counter() {
        cnt++;
        System.out.println("Counter()");
    }

    public static int getCount() {
        return cnt;
    }
}

public class StaticDemo {

    private String sname = "Static variable";

    public static void first() {
        Arrays.asList("one");
        asList("one");
    }

    public static void second() {
    }

    public void third() {
        System.out.println(sname);
    }

    public static void main(String[] args) {

        first();
        second();
        // third(); //DOES NOT COMPILE Cannot make a static reference to the non-static
        // method

        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();

        // ✅ Use class name to access static methods
        System.out.println(Counter.getCount()); // 3

        // Java allows calling a static method using an instance (c1.getCount()), but
        // this is bad practice and generates a warning.
        System.out.println(c1.getCount()); // warning: static method should be accessed in a static way
        System.out.println(c2.getCount()); // warning: static method should be accessed in a static way

    }

}
