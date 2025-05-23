package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDemo {
    public static void main(String[] args) {

        Runnable task = () -> {
            int rand = ThreadLocalRandom.current().nextInt(101); // highest exclusive
            System.out.println(Thread.currentThread().getName() + " generated: " + rand);
        }; // Do not forget the semicolon after the lambda expression

        // Create a thread pool with 4 threads
        // and submit 10 tasks to it
        // Note that the thread pool will be closed automatically
        try (var executor = Executors.newFixedThreadPool(3)) {

            for (int i = 0; i < 6; i++) {
                executor.submit(task);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
