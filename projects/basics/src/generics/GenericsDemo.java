package generics;

import java.util.ArrayList;
import java.util.List;

import domain.Car;
import inheritance.animals.domestic.Dog;
import util.Util;

class Animal {
}

// Mammal is a type of Animal
class Mammal extends Animal {
}

// Cat is a type of Mammal
class Cat extends Mammal {
}

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
    public static <T> Crate2<T> ship(T t) {
        System.out.println("Shipping " + t);
        return new Crate2<T>();
    }

    public static <T, U> void printPair(T first, U second) {
        System.out.println("First: " + first + ", Second: " + second);
    }

}

public class GenericsDemo {

    // overly restrictive method that can ONLY handle List<Number> objects
    public void printListofNumbers(List<Number> list) {
        for (Number x : list)
            System.out.println(x);
    }

    public void printListExtends(List<? extends Number> list) {
        for (Number x : list) {
            System.out.println(x);
        }

        // We don’t know the exact type of the list here in method body.
        // Hence, we can’t add integers to it, maybe we receive a list of Doubles!
        // list.add(1); // ❌ DOES NOT COMPILE
    }

    public void printListSuper(List<? super Number> list) {
        for (var x : list) {
            System.out.println(x);
        }

        list.add(1); // ✅ Adds an Integer to the list
        list.add(3.14); // ✅ Adds a Double to the list
        list.add(3.0f); // ✅ Adds a Float to the list
    }

    // Generic Method
    // The method accepts two arguments of type T and returns a double
    // The type T must be a subtype of Number
    public static <T extends Number> double sum(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    // Generic Method
    // Restrictive - only accepts a List where the type of the List and the return
    // type are exactly the same. This method is useful when you need to ensure that
    // the input list contains elements of the exact type you expect.
    // For example, it would accept a List<String> and return a String
    <T> T firstv1(List<T> list) {
        return list.get(0);
    }

    // Generic Method
    // The use of <? extends T> allows for covariance
    // can handle a wider range of input lists.
    // Accepts a List of any subtype of T and returns a value of type T
    // For example, it would accept a List<Dog> and return a Animal
    <T> T firstv2(List<? extends T> list) {
        return list.get(0);
    }

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

    public void hetereogeneousList() {

        // Java arrays are covariant, which can lead to runtime errors.
        Number[] nums = new Integer[10]; // This is allowed in Java arrays
        nums[0] = 1; // This is allowed
        // nums[1] = 3.14; // will throw ArrayStoreException at runtime

        // List<? extends Number> intList = new ArrayList<Integer>();
        // List<? extends Number> doubleList = new ArrayList<Double>();

        // In generics, Java enforces type safety at compile time.
        // This is to prevent runtime errors like the one above.

        List<Object> objects = new ArrayList<>(); // can hold any type of object.

        // autoboxing to convert primitive values to their corresponding wrapper classes
        objects.add("one");
        objects.add(1);
        objects.add(3.14);
        objects.add(true);
        System.out.println(objects); // [one, 1, 3.14, true]

        List<Number> numbers = new ArrayList<>(); // can hold any type of Number.
        numbers.add(1); // autoboxing to Integer
        numbers.add(3.14); // autoboxing to Double
        numbers.add(3.0f); // autoboxing to Float

        System.out.println(numbers); // [1, 3.14, 3.0]
    }

    void unknownSpecificTypes() {

        List<?> list1 = new ArrayList<Animal>();
        List<? extends Animal> list2 = new ArrayList<Animal>();
        List<? extends Animal> list3 = new ArrayList<Mammal>();
        List<? extends Animal> list4 = new ArrayList<Cat>();

        List<? super Animal> list5 = new ArrayList<Animal>();
        List<? super Animal> list6 = new ArrayList<Object>();
    }

    public void boundTypeParameters() {
        NumberBox<Number> numberBox1 = new NumberBox<>(1);
        NumberBox<Number> numberBox2 = new NumberBox<>(2.71);
        NumberBox<Integer> intBox = new NumberBox<>(1);
        NumberBox<Double> doubleBox = new NumberBox<>(3.14);
        // NumberBox<String> stringBox = new NumberBox<>("one"); // ❌ DOES NOT COMPILE
        // Bound mismatch

        // int val1 = numberBox1.getValue(); // DOES NOT COMPILE Type mismatch
        int val2 = intBox.getValue(); // 1
        doubleBox.getValue(); // 3.14
    }

    public void genericMethods() {

        Car car = new Car("Kia", "Sorento", 2007);
        List<Integer> intList = new ArrayList<>(List.of(1, 2, 3));
        List<Double> doubleList = new ArrayList<>(List.of(1.1, 2.2, 3.3));
        List<String> stringList = new ArrayList<>(List.of("one", "two", "three"));

        GenericUtils.printValue(1); // Generic printer: 1
        GenericUtils.printValue("Hello"); // Generic printer: Hello
        GenericUtils.printValue(car); // Generic printer: Car(Kia, Sorento, 2007)

        Util.header("******** GenericUtils.returnBack");
        int r1 = GenericUtils.returnBack(1); // 1
        String r2 = GenericUtils.returnBack("Hello"); // Hello
        Car r3 = GenericUtils.returnBack(car); // Car(Kia, Sorento, 2007)

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        Util.header("GenericUtils.printPair");
        GenericUtils.printPair("Hello", car); // First: Hello, Second: Car(Kia, Sorento, 2007)

        Util.header("GenericUtils.returnBackNumber");
        int r4 = GenericUtils.returnBackNumber(1); // 1
        double r5 = GenericUtils.returnBackNumber(3.14); // 3.14
        // Car r6 = GenericUtils.returnBackNumber(car); // DOES NOT COMPILE Not
        // applicable for arguments

        System.out.println(r4);
        System.out.println(r5);

        Util.header("GenericUtils.firstv2");
        int r7 = GenericUtils.firstv2(intList); // 1

        System.out.println(r7);

        GenericBox<Integer> intBox1 = new GenericBox<>(1);
        GenericBox<Integer> intBox2 = new GenericBox<>(1);
        GenericBox<Double> doubleBox = new GenericBox<>(3.14);

        double res1 = GenericUtils.addSameNumberSubtypes(intBox1, intBox2); // 2.0
        double res2 = GenericUtils.addDifferentNumberSubtypes(intBox1, doubleBox); // 4.14

        System.out.println(res1);
        System.out.println(res2);
    }

    public static void main(String[] args) {

        GenericsDemo demo = new GenericsDemo();

        // demo.hetereogeneousList();
        // demo.boundTypeParameters();
        demo.genericMethods();

        GenericBox<Integer> boxInt = new GenericBox<>(1);
        GenericBox<Double> boxDouble = new GenericBox<>(3.14);
        GenericBox<String> boxString = new GenericBox<>("one");
        GenericBox<Car> boxCar = new GenericBox<>(new Car("Kia", "Sample", 2007));

        int intValue = boxInt.getValue();
        double doubleValue = boxDouble.getValue();
        String stringValue = boxString.getValue();
        Car carValue = boxCar.getValue();

        System.out.println(intValue); // 1
        System.out.println(doubleValue); // 3.14
        System.out.println(stringValue); // one
        System.out.println(carValue); // Car(Kia, Sample, 2007)

        //

        // Generic Record
        GenericRecord<Integer> recordInt = new GenericRecord<>(1);
        GenericRecord<Double> recordDouble = new GenericRecord<>(3.14);
        GenericRecord<String> recordString = new GenericRecord<>("one");
        System.out.println(recordInt.value()); // 1
        System.out.println(recordDouble.value()); // 3.14
        System.out.println(recordString.value()); // one

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

        // String res1 = Handler2.prepare("Bananas");
        // Integer res2 = Handler2.prepare(1); // autoboxing

        // // You can call a generic method normally, and the compiler will try to
        // figure
        // // out
        // Crate2<String> strCrate = Handler2.ship("Apples");
        // Crate2<Integer> intCrate = Handler2.ship(10);

        // // Alternatively, you can specify the type explicitly
        // Crate2<String> strCrate2 = Handler2.<String>ship("String");
        // Crate2<Integer> intCrate2 = Handler2.<Integer>ship(1);

        List<String> stringList3 = new ArrayList<>();
        // stringList.add("Hello");

        // This would cause a compile-time error:
        // List<Object> objectList = stringList3; // DOES NOT COMPILE Type mismatch

        // If the above assignment were allowed, this could happen:
        // objectList.add(123); // via using an alias, adding an Integer to a supposed
        // List<String>

        List<Number> numberList = new ArrayList<>();
        numberList.add(1); // autoboxing to Integer
        numberList.add(2.0); // autoboxing to Double
        numberList.add(3.0f); // autoboxing to Float

        Util.header("********");
        demo.printListExtends(numberList);
        demo.printListofNumbers(numberList);

        List<Integer> intList2 = new ArrayList<>(List.of(1, 2, 3));

        // demo.printListofNumbers(intList2); // DOES NOT COMPILE not applicable for
        // arguments of type List<Integer>
        demo.printListExtends(intList2); // OK

        double sum1 = sum(1, 2); // 3.0
        double sum2 = sum(1.0, 2.0); // 3.0
        double sum3 = sum(1.0f, 2.0f); // 3.0

        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
    }
}
