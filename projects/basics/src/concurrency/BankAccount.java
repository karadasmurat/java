package concurrency;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;



public class BankAccount {

    private Lock vault = new ReentrantLock();
    private int total = 0;

    public void deposit(int value) {

        if (vault.tryLock()) { // returns immediately with a value of false if the lock cannot be acquired

            // Critical section (do something while holding the lock)
            try {
                total += value;
            } finally {
                // Always unlock in a finally block to ensure the lock is released
                // even if an exception occurs in the critical section
                // This is important to avoid deadlocks and to ensure that other threads can
                // access the lock
                // if the lock is not released, other threads will be blocked and will not be
                // able to access the lock
                vault.unlock();
            }
        } else {
            System.out.println("Tried, but failed to lock: " + value);
        }
    }

    public static void main(String[] args) {

        var account = new BankAccount();
        var deposits = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Create a thread pool with 3 threads
        // and submit 10 tasks to it to deposit money
        // Note that the thread pool will be closed automatically
        // and the tasks will be executed in parallel

        try (var executor = java.util.concurrent.Executors.newFixedThreadPool(3)) {
            for (var amount : deposits) {
                executor.submit(() -> account.deposit(amount)); // capture the amount in a no-argument lambda
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Using parallel streams
        // IntStream.range(1, 10)
        // .parallel()
        // .forEach(s -> bank.deposit(s));

        System.out.println(account.total);
    }
}
