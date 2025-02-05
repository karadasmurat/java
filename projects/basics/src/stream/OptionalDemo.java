package stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalDemo {

    public void basics() {
        // It is common to want to use empty() when the value is null.
        Optional<String> emptyOpt = Optional.empty();

        // Wrap a non-null value into an Optional
        Optional<String> opt = Optional.of("Value");

        // Wrap a value, but allow it to be null.
        Optional<String> opt2 = Optional.ofNullable(null); // Returns Optional.empty()
        Optional<String> opt3 = Optional.ofNullable("Java"); // Returns Optional[Java]

        // Retrieving values from Optional
        // Dealing with an empty Optional

        if (opt.isPresent()) { // check if a value exists
            System.out.println(opt.get()); // Prints value if present
        }

        // Execute Action if Value Exists
        opt.ifPresent(val -> System.out.println("Value: " + val));

        // Retrieving value, Provide a default value
        String result1 = opt.orElse("Default Value");

        // Throw an Exception if Empty
        String result2 = opt.orElseThrow(() -> new RuntimeException("Value missing!"));
    }

    public void lazyEvaluation() {
        Stream<String> stream = List.of("apple", "banana", "cherry", "date").stream()
                .filter(s -> {
                    System.out.println("Filtering: " + s);
                    return s.startsWith("b");
                })
                .map(s -> {
                    System.out.println("Mapping: " + s);
                    return s.toUpperCase();
                });

        System.out.println("Stream defined, but not executed yet!");

        // Terminal operation triggers execution
        System.out.println("Result: " + stream.findFirst().orElse("Not Found"));
    }

    public static void main(String[] args) {

        OptionalDemo demo = new OptionalDemo();
        // demo.basics();
        demo.lazyEvaluation();

    }
}
