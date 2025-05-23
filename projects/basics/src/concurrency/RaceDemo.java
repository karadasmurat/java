package concurrency;

import java.util.concurrent.Executors;

class SimpleValue {
    private int value;

    public SimpleValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void stepOne() throws InterruptedException {

        System.out.println(Thread.currentThread().getName() + " stepOne");
        Thread.sleep(300);
        value = 1;

    }

    public void stepTwo() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " stepTwo");
        Thread.sleep(200);
        value = 2;
    }

    public void stepThree() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " stepThree");
        Thread.sleep(100);
        value = 3;
    }

    public void processValue() {
        try {
            stepOne();
            stepTwo();
            stepThree();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

public class RaceDemo {

    private int counter = 0;

    // Method to increment the instance variable
    // Note that this method is NOT synchronized
    public void increment() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {

        RaceDemo shared = new RaceDemo();
        SimpleValue value = new SimpleValue(0);

        Runnable rtask = shared::increment;
        Runnable rtask2 = value::processValue;

        try (var executor = Executors.newFixedThreadPool(3);) {
            for (int i = 0; i < 10; i++) {

                // Using a lambda expression to create a Runnable
                // executor.execute(() -> {
                // shared.increment();
                // });

                // Alternatively, you can use a method reference
                // executor.execute(shared::increment);
                // executor.execute(rtask);
                executor.execute(rtask2);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Value: " + value.getValue());

        // Create two threads that will increment the counter 1000 times each

        // Thread t1 = new Thread(rtask);
        // Thread t2 = new Thread(rtask);

        // t1.start();
        // t2.start();

        // t1.join();
        // t2.join();

        // Final result is unpredictable due to the race condition
        // System.out.println("Counter value: " + shared.counter);
    }
}
