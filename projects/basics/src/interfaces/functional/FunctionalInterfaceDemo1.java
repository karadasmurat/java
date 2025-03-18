package interfaces.functional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import domain.Car;
import inheritance.animals.Animal;
import util.Util;

class Score {
    int value;

    public Score(int value) {
        this.value = value;
    }

    public int getValue() {

        return value;
    }

    // instance method, service to Score objects
    public boolean hasPassed() {
        System.out.println("hasPassed()");
        return this.value > 60;
    }

    // static utility method, service to Integer objects
    public static boolean checkUtility(Integer score) {
        System.out.println("checkUtility()");
        return score > 60;
    }
}

class ScoreUtils {

    // static utility method, service to Score objects
    public static boolean checkScore(Score score) {
        System.out.println("ScoreUtils.checkScore()");
        return score.getValue() > 60;
    }

}

public class FunctionalInterfaceDemo1 {

    // Implementing Predicate.test(T)
    // score -> score > 60
    public static boolean hasPassed(int score) {
        return score > 60;
    }

    public void predicates() {
        // Lambda creating a close!
        // Variable used in lambda should be final or effectively final.
        // The lambda does not modify the captured variable but can use it.
        int threshold = 60;

        Integer scoreVAL = 65;
        Score scoreOBJ = new Score(scoreVAL);

        Predicate<Integer> predicate1a = x -> x > threshold;

        // use an existing static utility method in lambda
        Predicate<Integer> predicate2a = x -> Score.checkUtility(x);
        Predicate<Score> predicate4a = x -> ScoreUtils.checkScore(x);

        // a lambda expression that takes an object (x) and calls a method on it.
        Predicate<Score> predicate3a = x -> x.hasPassed();

        // method reference
        Predicate<Integer> predicate1b = FunctionalInterfaceDemo1::hasPassed;

        // use an existing static utility method reference
        Predicate<Integer> predicate2b = Score::checkUtility;
        Predicate<Score> predicate4b = ScoreUtils::checkScore;

        // use an existing instance method reference
        // Predicate<Score> expects a method that takes a Score argument
        // (test(Score t))
        Predicate<Score> predicate3b = Score::hasPassed;

        if (predicate1a.test(scoreVAL)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        if (predicate4a.test(scoreOBJ)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        Util.header("instance method reference");
        // lambda
        Predicate<String> predicateEmptyStr1 = x -> x.isEmpty();
        boolean res1 = predicateEmptyStr1.test(""); // true
        System.out.println(res1);

        // Instance method reference
        Predicate<String> predicateEmptyStr2 = String::isEmpty;
        boolean res2 = predicateEmptyStr2.test(""); // true
        System.out.println(res2);

        List<String> list = new ArrayList<>(List.of("Alice", "  ", "Bob", "", "David"));
        long blankCnt = list.stream().filter(String::isBlank).count();
        System.out.println("# blanks: " + blankCnt); // 2
    }

    public void suppliers() {

        // v1. anonymous class
        Supplier<String> greetingSupplier1 = new Supplier<String>() {
            @Override
            public String get() {
                return "Hello, World!";
            }
        };

        // Calling get() method
        String str1 = greetingSupplier1.get();
        System.out.println(str1); // Output: Hello, World!

        // v2. Lambda
        // Supplier that provides a greeting message
        Supplier<String> greetingSupplier2 = () -> "Hello, World!";

        // Calling get() method
        String str2 = greetingSupplier2.get();
        System.out.println(str2); // Output: Hello, World!

        Supplier<LocalDate> supplier1 = () -> LocalDate.now();
        Supplier<LocalDate> supplier2 = LocalDate::now;

        LocalDate date1 = supplier1.get();
        LocalDate date2 = supplier2.get();

        System.out.println(date1);
        System.out.println(date2);

        // v3. method reference
        Supplier<String> greetingSupplier3 = String::new;
        String str3 = greetingSupplier3.get();

        Supplier<StringBuilder> s1 = StringBuilder::new;
        Supplier<StringBuilder> s2 = () -> new StringBuilder();

        System.out.println(s1.get()); // Empty string
        System.out.println(s2.get()); // Empty string

        // Checked Exceptions
        Supplier<List<Car>> carSupplier1 = Car::sampleCarList;
        Supplier<List<Car>> carSupplier2 = Car::maySupply; // Unhandled exception type IOException
    }

    public void consumers() {

        Consumer<String> consumer1 = x -> System.out.println(x);
        Consumer<String> consumer2 = System.out::println;

        consumer1.accept("Bob");
        consumer2.accept("Alice");

        // BiConsumer
        var map = new HashMap<String, Integer>();

        BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);

        // call put method on this specific instance: map
        BiConsumer<String, Integer> b1 = map::put;

        b1.accept("chicken", 7);
        b2.accept("chick", 1);

        System.out.println(map); // {chicken=7, chick=1}

    }

    public void functions() {

        Function<String, Integer> stringToLength = str -> str.length();
        Integer len1 = stringToLength.apply("Alice");
        System.out.println(len1); // 5

        Function<String, Integer> function2 = String::length;

        // int len = function1.apply("Alice");
        int len = function2.apply("Alice");
        System.out.println(len); // 5

        // Remember that ToIntFunction is specialized Function, where R = int
        ToIntFunction<String> stringToLength2 = String::length;
        int len2 = stringToLength2.applyAsInt("Alice");
        System.out.println(len2); // 5

    }

    public void operators() {

        UnaryOperator<String> upperCase = str -> str.toUpperCase();
        String result1 = upperCase.apply("Alice");
        System.out.println(result1); // ALICE

        // String.concat() method and its equivalent usage with a BinaryOperator.
        // str1.concat(str2) and concatOp.apply(str1, str2) produce the same result
        String str1 = "Hello,";
        String str2 = "there!";
        String res0 = str1.concat(str2);
        System.out.println(res0);

        // method reference String::concat is used to create the BinaryOperator
        // instance.
        BinaryOperator<String> concatOp = String::concat;
        String res1 = concatOp.apply(str1, str2); // Hello, there!
        System.out.println(res1);

        BinaryOperator<Integer> addOp = Integer::sum;

        int res2 = addOp.apply(1, 2); // 3
        System.out.println(res2);

        BinaryOperator<Integer> multOp = (a, b) -> a * b;
        int res3 = multOp.apply(5, 10); // 50
        System.out.println(res3);

        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(3);
        Stream<Integer> threeElements = Stream.of(3, 5, 6);

        System.out.println("Reducing an empty stream:");
        empty.reduce(multOp).ifPresent(System.out::println); // no output

        System.out.println("Reducing a one-element stream:");
        oneElement.reduce(multOp).ifPresent(System.out::println);

        System.out.println("Reducing a multi-element stream:");
        threeElements.reduce(multOp).ifPresent(System.out::println);
    }

    public static void main(String[] args) {

        FunctionalInterfaceDemo1 demo = new FunctionalInterfaceDemo1();

        // demo.predicates();
        // demo.suppliers();
        // demo.consumers();
        // demo.functions();
        demo.operators();

    }
}
