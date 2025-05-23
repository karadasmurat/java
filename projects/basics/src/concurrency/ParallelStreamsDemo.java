package concurrency;

public class ParallelStreamsDemo {

    private static int process(int value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void main(String[] args) {

        var numbers = java.util.List.of(1, 2, 3, 4, 5);

        long start = System.currentTimeMillis();

        numbers.stream().parallel()
                .map(n -> process(n))
                .forEach(s -> System.out.print(s + " "));

        var timeTaken = (System.currentTimeMillis() - start) / 1000;
        System.out.println("Time: " + timeTaken + " seconds");

    }
}




