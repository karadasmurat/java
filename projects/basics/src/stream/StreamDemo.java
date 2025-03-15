package stream;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import domain.Car;
import util.Util;

public class StreamDemo {

    public void simpleFilter() {

        List<Car> cars = Car.sampleCarList();

        // All cars
        System.out.println("*** All cars:");
        cars.stream().forEach(System.out::println);

        // Filtering cars
        System.out.println("*** Classic cars:");
        cars.stream().filter(Car::isClassic).forEach(System.out::println);

        System.out.println("*** All BMWs:");
        cars.stream().filter((Car c) -> c.getMake().equals("BMW")).forEach(System.out::println);

        System.out.println("*** A BMW:");
        Optional<Car> aBMW = cars.stream().filter((Car c) -> c.getMake().equals("BMW")).findFirst();
        aBMW.ifPresent(System.out::println);

        // Find the oldest car
        System.out.println("*** The oldest:");
        Optional<Car> oldestCar = cars.stream().min((c1, c2) -> Integer.compare(c1.getYear(), c2.getYear()));
        oldestCar.ifPresent(System.out::println);

        // count the number of elements in a finite stream
        long cnt = cars.stream().count();
        System.out.println("# cars: " + cnt);

    }

    public void pipeline() {

        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Anna");

        // Stream pipeline
        List<String> filteredNames = names.stream() // Source
                .filter(name -> name.startsWith("A")) // Intermediate operation
                .map(String::toUpperCase) // Intermediate operation
                .sorted() // Intermediate operation
                .collect(Collectors.toList()); // Terminal operation

        System.out.println(filteredNames); // [ALICE, ANNA]

        Stream<String> stream = List.of("apple", "banana", "blackberry", "date").stream()
                .filter(s -> {
                    System.out.println("Filtering: " + s);
                    return s.startsWith("b");
                })
                .map(s -> {
                    System.out.println("Mapping: " + s);
                    return s.toUpperCase();
                });

        System.out.println("Stream defined, but not executed yet, because no terminal operation has been called!");

        // Terminal operation triggers execution
        System.out.println("Result: " + stream.findFirst().orElse("Not Found"));
    }

    public void create() {
        Stream<String> empty = Stream.empty(); // count = 0
        Stream<Integer> singleElement = Stream.of(1); // count = 1
        Stream<Integer> fromArray = Stream.of(1, 2, 3); // count = 3

        // create a parallel stream from a list
        var list = List.of("a", "b", "c");
        Stream<String> fromListParallel = list.parallelStream();

        // converting a Collection to a stream.
        var list2 = List.of("a", "b", "c");
        Stream<String> fromList = list2.stream();

        // Infinite Streams: Remember that the source doesn’t actually create the values
        // until you call a terminal operation.

        Supplier<String> supplier1 = () -> "Hi there!";
        Supplier<LocalDate> dateSupplier = () -> LocalDate.now();
        Supplier<String> supplier2 = Util::getGreeting;

        Stream<String> generated1 = Stream.generate(supplier1);
        Stream<LocalDate> generated2 = Stream.generate(dateSupplier);

        generated1.limit(3).forEach(System.out::println);
        generated2.limit(3).forEach(System.out::println);

        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
    }

    public static void main(String[] args) {

        StreamDemo demo = new StreamDemo();
        demo.create();
        // demo.simpleFilter();
        // demo.pipeline();
    }

}
