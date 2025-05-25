package tmp;

import java.util.List;

public class Main {

  public static void main(String[] args) {

    var data = List.of(2, 5, 1, 9, 8);
    data.stream().parallel()
        // .mapToInt(s -> s)
        // .peek(System.out::print) // In parallel streams, peek() may print in an
        // unpredictable order, since
        // elements are processed in parallel.

        .forEachOrdered(System.out::print);

  }
}
