package generics;

import java.util.ArrayList;
import java.util.List;

class Crate<T> {
}

// Note that Handler is not a generic class.
class Handler {

    // A generic method that takes a parameter of type T and returns T
    public static <T> T prepare(T t) {
        System.out.println("Preparing " + t);
        return t;
    }

    // A generic method that takes a parameter of type T and returns Crate<T>
    public static <T> Crate<T> ship(T t) {
        System.out.println("Shipping " + t);
        return new Crate<T>();
    }

    public static <T, U> void printPair(T first, U second) {
        System.out.println("First: " + first + ", Second: " + second);
    }

}

public class GenericsDemo {

    // Generic method
    // Defines a new generic type T (T extends Number) that is used only in this
    // method.
    // T is a placeholder for a specific type, which will be determined at the time
    // of method invocation.
    // Returns a value of type T
    public static <T extends Number> T getFirstElement(List<T> list) {
        return list.get(0); // ✅ Returns the first element while preserving its type
    }

    // Using a wildcard ? extends Number
    // Method that accepts a List of unknown subtype of Number
    public static void printNumbers(List<? extends Number> list) {

        // We can read from the list
        for (Number num : list) {
            System.out.println(num);
        }

        // We don’t know the exact type of the list here in method body.
        // Hence, we can’t add integers to it, maybe it’s a list of doubles.
        // list.add(10); // ❌ DOES NOT COMPILE
    }

    public static void main(String[] args) {

        GenericBox<Integer> boxInt = new GenericBox<>(1);
        GenericBox<Double> boxDouble = new GenericBox<>(3.14);
        // GenericBox<String> boxString = new GenericBox<>("one"); // ❌ DOES NOT COMPILE
        // Bound mismatch

        int intValue = boxInt.getValue();
        double doubleValue = boxDouble.getValue();

        System.out.println(intValue); // 1
        System.out.println(doubleValue); // 3.14

        // List of Integers as argument to printNumbers
        List<Integer> intList = List.of(1, 2, 3);
        printNumbers(intList);

        // Java infers the type of T based on the input argument
        int firstInt = getFirstElement(intList);
        System.out.println("First:" + firstInt);

        // List of Doubles as argument to printNumbers
        List<Double> doubleList = List.of(1.1, 2.2, 3.3);
        printNumbers(doubleList);

        double firstDouble = getFirstElement(intList);
        System.out.println("First:" + firstDouble);

        // List of Strings as argument to printNumbers
        List<String> stringList = List.of("one", "two", "three");
        // printNumbers(stringList); // ❌ DOES NOT COMPILE

        String res1 = Handler.prepare("Bananas");
        Integer res2 = Handler.prepare(1); // autoboxing

        // You can call a generic method normally, and the compiler will try to figure
        // out
        Crate<String> strCrate = Handler.ship("Apples");
        Crate<Integer> intCrate = Handler.ship(10);

        // Alternatively, you can specify the type explicitly
        Crate<String> strCrate2 = Handler.<String>ship("String");
        Crate<Integer> intCrate2 = Handler.<Integer>ship(1);

        List<String> stringList3 = new ArrayList<>();
        stringList.add("Hello");

        // This would cause a compile-time error:
        // List<Object> objectList = stringList3; // DOES NOT COMPILE Type mismatch

        // If the above assignment were allowed, this could happen:
        // objectList.add(123); // via using an alias, adding an Integer to a supposed List<String>
    }
}
