package stream;

import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

    public void create() {
        Stream<String> empty = Stream.empty(); // count = 0
        Stream<Integer> singleElement = Stream.of(1); // count = 1
        Stream<Integer> fromArray = Stream.of(1, 2, 3); // count = 3

        // converting a Collection to a stream.
        var list = List.of("a", "b", "c");
        Stream<String> fromList = list.stream();

        // Infinite Streams: Remember that the source doesn’t actually create the values
        // until you call a terminal operation.
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
    }

    public static void main(String[] args) {
        StreamDemo demo = new StreamDemo();
        demo.create();
    }

}
