package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulingDemo {

    public static void main(String[] args) {

        Runnable rtask = () -> System.out.println(Thread.currentThread().getName() + " is working.");

        // var execs1 = Executors.newScheduledThreadPool(4); // execs is of type
        // ScheduledExecutorService
        // execs1.schedule(rtask, 0, TimeUnit.MILLISECONDS);

        // ExecutorService execs2 = Executors.newScheduledThreadPool(4);
        // execs2.schedule(rtask, 0, TimeUnit.MILLISECONDS); // CompileERR
        // execs2.submit(rtask); // OK

        // Create a thread pool with 4 threads and submit a task to it
        // try (var execs = Executors.newScheduledThreadPool(4)) {
        // Schedule a task (Callable) to run after a delay
        // var res = execs.schedule(rtask, 0, TimeUnit.MILLISECONDS);
        // } // shutdown the thread pool automatically

        // Schedule a task (Callable) to run after a delay
        // var res = execs.schedule(() -> "Hi!", 0, TimeUnit.MILLISECONDS);

        // Create a thread pool with 4 threads and schedule a task to it
        try (var service = Executors.newScheduledThreadPool(4)) {

            service.schedule(() -> System.out.println("Hello"), 1,
                    java.util.concurrent.TimeUnit.SECONDS);

            // } catch (Exception e) {
            // // TODO: handle exception
            // }
        }

        var service = Executors.newScheduledThreadPool(4);
        service.scheduleAtFixedRate(() -> System.out.println("Periodic Hello!"), 1, 1,
                java.util.concurrent.TimeUnit.SECONDS);
        // service.scheduleWithFixedDelay(() -> System.out.println("Hello"), 1, 1,
        // java.util.concurrent.TimeUnit.SECONDS);
    }
}
