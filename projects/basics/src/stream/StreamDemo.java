package stream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import clone.Person;
import domain.Car;
import inheritance.animals.Animal;
import inheritance.animals.domestic.Cat;
import util.Util;

public class StreamDemo {

    public void simpleFilter() {

        List<Car> cars = Car.sampleCarList();

        // All cars
        System.out.println("*** All cars:");
        cars.stream().forEach(System.out::println);

        // Filtering cars
        System.out.println("*** Classic cars:");

        // method reference used as Predicate
        Stream<Car> classics = cars.stream().filter(Car::isClassic);
        cars.stream().filter(Car::isClassic).forEach(System.out::println);
        System.out.println("*** All BMWs:");
        // lambda used as Predicate
        Stream<Car> bmws = cars.stream().filter((Car c) -> c.getMake().equalsIgnoreCase("BMW"));
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

        // distinct
        List<String> members = List.of("Harry", "HARRY", "harry", "Harry");
        members.stream().distinct().forEach(System.out::println);

        // limit
        Stream<Double> infiniteStream = Stream.generate(Math::random);
        infiniteStream.limit(3).forEach(System.out::println);

        // skip
        UnaryOperator<Integer> incrementOp = n -> n + 1;
        Stream<Integer> stream = Stream.iterate(1, incrementOp);
        stream.skip(3).limit(5).forEach(System.out::println); // 4 5 6 7 8

    }

    public void map() {

        List<Car> cars = Car.sampleCarList();

        // Extracting car makes
        List<String> makes = cars.stream().map(Car::getMake).collect(Collectors.toList());
        System.out.println(makes);

        List<Cat> cats = List.of(new Cat("MrCat"), new Cat("MrsCat"));

        // T is the type of input stream
        // map takes a Function: Function<? super T,? extends R> mapper)
        // notice that T is the input stream's type, and the mapper Function can take
        // parent type.
        // therefore an
        Function<Animal, String> ageMapper1 = Util::getAgeCategoryOfAnimal;
        Function<Animal, String> ageMapper2 = Animal::getAgeCategory;

        List<String> ages = cats.stream().map(ageMapper2).collect(Collectors.toList()); // [BABY, BABY]
        System.out.println(ages);

    }

    public void flatmap() {
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d", "e"),
                Arrays.asList("f"));

        Stream<String> flattenedStream = nestedList.stream()
                .flatMap(List::stream);

        flattenedStream.forEach(System.out::println);
    }

    public void match() {

        List<Integer> scores = List.of(80, 90, 60, 70, 50, 40, 30, 80, 65, 75, 55, 90, 80);
        List<String> identifiers = List.of("color", "_color", "1color", "c*l*r");
        List<Car> cars = Car.sampleCarList();

        // anyMatch
        boolean hasFail = scores.stream().anyMatch(n -> n < 60);
        boolean hasBMWs = cars.stream().anyMatch(c -> c.getMake().equals("BMW"));
        boolean hasClassics = cars.stream().anyMatch(Car::isClassic);
        boolean anyBeginsWithDigits = identifiers.stream().anyMatch((String s) -> Character.isDigit(s.charAt(0)));

        System.out.println("Any Fail scores?: " + hasFail); // true
        System.out.println("Any BMWs?: " + hasBMWs); // true
        System.out.println("Any Classics?: " + hasClassics); // true
        System.out.println("Any begins with digits?: " + anyBeginsWithDigits); // true

    }

    public void reduce() {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // a reduction to add all of the Integer objects in a stream
        int total1 = numbers.stream().reduce(0, (a, b) -> a + b); // 15
        int total2 = numbers.stream().reduce(0, Integer::sum); // 15

        System.out.println(total1);
        System.out.println(total2);

        // int sum = numbers.stream()
        List<Integer> transformedNumbers = numbers.stream()
                .filter(n -> {
                    System.out.println("Filtering: " + n);
                    return n % 2 != 0;
                }) // Filter out even numbers
                .map(n -> {
                    System.out.println("Mapping: " + n);
                    return n * 2;
                }) // Multiply by 2
                   // .reduce(0, Integer::sum); // Sum the results
                .collect(Collectors.toList());

        // System.out.println(sum); // Output: 50
        System.out.println(transformedNumbers); // [2, 6, 10]

        BinaryOperator<Integer> multOp = (a, b) -> a * b;
        int res3 = multOp.apply(5, 10); // 50
        System.out.println(res3);

        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(3);
        Stream<Integer> threeElements = Stream.of(3, 5, 6);

        // No identity: reduce(BinaryOperator)
        System.out.println("Reducing an empty stream:");
        empty.reduce(multOp).ifPresent(System.out::println); // no output

        System.out.println("Reducing a one-element stream:");
        oneElement.reduce(multOp).ifPresent(System.out::println); // 3

        System.out.println("Reducing a multi-element stream:");
        threeElements.reduce(multOp).ifPresent(System.out::println); // 90
    }

    public void collect() {

        List<String> members = List.of("Harry", "Harry", "Ronald", "Hermione", "Draco");
        Stream<String> memberStream = members.stream();

        Stream<String> stream = Stream.of("w", "o", "l", "f");

        StringBuilder collected = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(collected);

        // Accumulate into a List
        System.out.println("Accumulate into a List: ");
        List<String> list = memberStream.collect(Collectors.toList()); // [Harry, Harry, Ronald, Hermione, Draco]
        System.out.println(list);

        System.out.println("Accumulate into a Set: ");
        memberStream = members.stream();
        TreeSet<String> set = memberStream.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        System.out.println(set); // [Draco, Harry, Hermione, Ronald]

        // If we dont need the set to be sorted
        System.out.println("Accumulate into a Set: ");
        memberStream = members.stream();
        Set<String> set2 = memberStream.collect(Collectors.toSet());
        System.out.println(set2);

        // If we dont need the set to be sorted
        System.out.println("Accumulate into a Set: ");
        memberStream = members.stream();
        Set<String> set3 = memberStream.collect(Collectors.toSet());
        System.out.println(set2);

        // Accumulate into a TreeSet
        System.out.println("Accumulate into a TreeSet: ");
        memberStream = members.stream();
        TreeSet<String> set4 = memberStream.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set4);

        System.out.println("Accumulate into an ArrayList: ");
        List<Car> cars = Car.sampleCarList();
        ArrayList<Car> res = cars.stream().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(res);

        // Collector that accumulates elements into a Map
        System.out.println("Accumulate into a Map: ");
        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> map = ohMy.collect(Collectors.toMap(s -> s, String::length));
        System.out.println(map);

        ohMy = Stream.of("lions", "tigers", "bears");
        String result1 = ohMy.collect(Collectors.joining(", "));
        System.out.println(result1); // lions, tigers, bears

        ohMy = Stream.of("lions", "tigers", "bears");
        Double result2 = ohMy.collect(Collectors.averagingInt(String::length));
        System.out.println(result2); // 5.333333333333333
    }

    public void groupingBy() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Adam");

        Map<Integer, List<String>> namesByLength = names.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(namesByLength);

        List<Car> cars = Car.sampleCarList();
        Map<String, List<Car>> makes = cars.stream().collect(Collectors.groupingBy(Car::getMake));
        System.out.println(makes);

        // downstream collector
        Map<Integer, Set<String>> namesByLengthSet = names.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));

        System.out.println(namesByLengthSet);

        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Long> map = ohMy.collect(
                Collectors.groupingBy(
                        String::length,
                        Collectors.counting()));
        System.out.println(map); // {5=2, 6=1}

        // mapFactory
        // change the type of Map
        ohMy = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, Set<String>> map2 = ohMy.collect(
                Collectors.groupingBy(
                        String::length,
                        TreeMap::new,
                        Collectors.toSet()));
        System.out.println(map2); // {5=[lions, bears], 6=[tigers]}

        ohMy = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> partitioned = ohMy.collect(
                Collectors.partitioningBy(s -> s.length() <= 5));
        System.out.println(partitioned); // {false=[tigers], true=[lions, bears]}
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

        var list = List.of("Toby", "Anna", "Leroy", "Alex");
        list.stream()
                .filter(n -> n.length() == 4)
                .sorted()
                .limit(2)
                .forEach(System.out::println);

        // hangs or throws exception after running out of memory
        // sorted waits until everything to sort is present
        Stream.generate(() -> "Elsa")
                .filter(n -> n.length() == 4)
                .sorted()
                .limit(2)
                .forEach(System.out::println);
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

        // Remember that streams are lazily evaluated.
        // This means the stream isn’t created on cats.stream().
        // An object is created that knows where to look for the data when it is needed.
        System.out.println("Linking Streams to the Underlying Data");
        var cats = new ArrayList<String>();
        cats.add("Annie");
        cats.add("Ripley");
        var stream = cats.stream();
        cats.add("KC");
        System.out.println(stream.count());
    }

    public void sorting() {

        List<Car> cars = Car.sampleCarList();

        System.out.println("*** Sort in natural order:");
        // Car implements Comparable<Car> and defines natural order
        cars.stream().sorted().forEach(System.out::println);

        System.out.println("*** Sort in reversed natural order:");
        // Car implements Comparable<Car> and defines natural order
        cars.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        System.out.println("*** Sort by Make:");
        cars.stream().sorted(Comparator.comparing(Car::getMake)).forEach(System.out::println);

    }

    public void peeking() {
        var stream = Stream.of("black bear", "gummy bear", "brown bear", "grizzly");
        long count = stream.filter(s -> s.startsWith("g"))
                .peek(System.out::println) // gummy bear grizzly
                .count(); // 2

        System.out.println(count); // 2
    }

    public void primitiveStreams() {

        // create an empty stream
        DoubleStream empty = DoubleStream.empty();

        DoubleStream varargs = DoubleStream.of(1.0, 1.1, 1.2);

        DoubleStream random = DoubleStream.generate(Math::random);
        random.limit(3).forEach(System.out::println);

        DoubleStream fractions = DoubleStream.iterate(.5, d -> d / 2);
        fractions.limit(3).forEach(System.out::println); // 0.5 0.25 0.125

        IntStream range = IntStream.range(1, 6);
        range.forEach(System.out::print); // 12345

        // primitive optional
        // OptionalDouble is for a primitive
        System.out.println("Primitive Optional:");
        var stream = IntStream.rangeClosed(1, 5);
        OptionalDouble avg = stream.average(); // 3.0
        avg.ifPresent(System.out::println);
        System.out.println(avg.getAsDouble());

        // mapping streams
        Stream<String> objStream = Stream.of("penguin", "fish");

        ToIntFunction<String> toIntFunc = s -> s.length(); // Generic Type Parameter String sets the type of input: s

        IntStream intStream = objStream.mapToInt(toIntFunc);

    }

    public void summaryStats() {
        IntStream numberStream = IntStream.of(1, 2, 3, 4, 5);

        IntSummaryStatistics stats = numberStream.summaryStatistics();

        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Average: " + stats.getAverage());
    }

    public void spliterators() {
        var stream = List.of("bird-", "bunny-", "cat-", "dog-", "fish-", "lamb-", "mouse-");
        Spliterator<String> originalBagOfFood = stream.spliterator();
        Spliterator<String> emmasBag = originalBagOfFood.trySplit();
        emmasBag.forEachRemaining(System.out::print); // bird-bunny-cat-

        Spliterator<String> jillsBag = originalBagOfFood.trySplit();
        jillsBag.tryAdvance(System.out::print); // dog-
        jillsBag.forEachRemaining(System.out::print); // fish-

        originalBagOfFood.forEachRemaining(System.out::print); // lamb-mouse
    }

    public static void main(String[] args) {

        StreamDemo demo = new StreamDemo();
        // demo.create();
        // demo.simpleFilter();
        // demo.pipeline();
        // demo.map();
        // demo.flatmap();
        // demo.match();
        // demo.reduce();
        // demo.collect();
        // demo.groupingBy();
        // demo.sorting();
        // demo.peeking();
        // demo.primitiveStreams();
        // demo.summaryStats();
        demo.spliterators();
    }

}
