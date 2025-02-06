package interfaces.functional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
    }

    public void suppliers() {

        // Supplier that provides a greeting message
        Supplier<String> greetingSupplier = () -> "Hello, World!";

        // Calling get() method
        String str = greetingSupplier.get();
        System.out.println(str); // Output: Hello, World!

        Supplier<LocalDate> supplier1 = () -> LocalDate.now();
        Supplier<LocalDate> supplier2 = LocalDate::now;

        LocalDate date1 = supplier1.get();
        LocalDate date2 = supplier2.get();

        System.out.println(date1);
        System.out.println(date2);

        Supplier<StringBuilder> s1 = StringBuilder::new;
        Supplier<StringBuilder> s2 = () -> new StringBuilder();

        System.out.println(s1.get()); // Empty string
        System.out.println(s2.get()); // Empty string
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

        Function<String, Integer> function1 = (String x) -> x.length();
        Function<String, Integer> function2 = String::length;

        // int len = function1.apply("Alice");
        int len = function2.apply("Alice");
        System.out.println(len); // 5

    }

    public static void main(String[] args) {

        FunctionalInterfaceDemo1 demo = new FunctionalInterfaceDemo1();

        // demo.predicates();
        // demo.suppliers();
        // demo.consumers();
        demo.functions();

    }
}
