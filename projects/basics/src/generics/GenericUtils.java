package generics;

import java.util.List;

public class GenericUtils {

    public static <T> void printValue(T arg) {
        System.out.println("Generic printer: " + arg);
    }

    public static <T> T returnBack(T arg) {
        return arg;
    }

    // public static <T> T f(T arg) {
    // return 1; // DOES NOT COMPILE Type mismatch: cannot convert from int to T
    // }

    public static <T, U> void printPair(T first, U second) {

        System.out.println("First: " + first + ", Second: " + second);
    }

    public static <T> T firstv1(List<T> list) {

        return list.get(0);
    }

    public static <T extends Number> T returnBackNumber(T num) {
        return num;
    }

    public static <T> T firstv2(List<? extends T> list) {

        return list.get(0);
    }

    // Generic method that can add two GenericBox objects
    // The type parameter T must be a Number or a subtype of Number
    // The method is designed to add the values of two GenericBox objects that
    // contain the same type of Number.
    // The type parameter T acts as a constraint, ensuring that both boxes hold the
    // same numeric type.
    public static <T extends Number> double addSameNumberSubtypes(GenericBox<T> box1, GenericBox<T> box2) {
        return box1.getValue().doubleValue() + box2.getValue().doubleValue();
    }

    // Generic method that can add two GenericBox objects
    // The type parameters T and U must be a Number or a subtype of Number
    // The method is designed to add the values of two GenericBox objects that
    // contain different subtypes of Number.
    public static <T extends Number, U extends Number> double addDifferentNumberSubtypes(GenericBox<T> box1,
            GenericBox<U> box2) {
        return box1.getValue().doubleValue() + box2.getValue().doubleValue();
    }

    // Generic method that can add two GenericBox objects
    // Using the wildcard ? extends Number, we can add two GenericBox objects that
    // contain different subtypes of Number.
    // public static double addDifferentNumberSubtypes(GenericBox<? extends Number>
    // box1, GenericBox<? extends Number> box2) {
    // return box1.getValue().doubleValue() + box2.getValue().doubleValue();
    // }

}
