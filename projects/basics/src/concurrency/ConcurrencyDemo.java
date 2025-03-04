package concurrency;

// Create a new thread by extending the Thread class and overriding the run method
// The run method contains the code that will be executed by the thread
// The start method is called to start the thread
// The run method should not be called directly, it is called by the start method

class BankAccount {
    private int balance;

    public BankAccount() {
        this.balance = 0;
    }

    public void deposit(int amount) {
        // Not atomic!
        balance += amount;
    }

    // synchronized method
    // Only one thread can execute this method at a time
    public synchronized void depositSync(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public String toString() {
        return "BankAccount(balance:" + balance + ")";
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Extending Thread!");
    }
}

// Create a new thread by implementing the Runnable interface
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Implementing Runnable!");
    }
}

public class ConcurrencyDemo {

    private int cnt = 0;

    public void create() {
        Thread t0 = new MyThread();
        // Set the priority of the thread
        t0.setPriority(Thread.MAX_PRIORITY); // 10
        t0.start(); // Start the thread

        Thread t1 = new Thread(new MyRunnable());
        t1.start(); // Start the thread

        // Create a new thread using an anonymous class
        // Anonymous classes are used when we need to create a class that is used only
        // once
        // The class is defined and instantiated at the same time
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Using an anonymous class!");
            }
        });
        t2.start(); // Start the thread

        Runnable runnable = () -> System.out.println("A resuable runnable!");

        Thread t3a = new Thread(runnable);
        Thread t3b = new Thread(runnable);
        Thread t3c = new Thread(runnable);

        Thread t4 = new Thread(() -> System.out.println("Thread is running..."));

        t3a.start(); // Start the thread
        t3b.start();
        t3c.start();

        t4.start();

        // Create a new thread using a lambda expression
        Thread t5 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread 1: " + i);
            }
        });

        t5.start();
    }

    void joinDemo() {
        System.out.println("joinDemo() started");

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread 1: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Thread 1 run finished");
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread 2: " + i);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread 2 run finished");
        });

        t1.start();
        t2.start(); // t2 may start before t1

        try {
            t2.join(); // Wait for shorter thread to finish
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
            e.printStackTrace();
        }

        System.out.println("joinDemo() finished");
    }

    void sequentialDeposit() {
        BankAccount account = new BankAccount();
        account.deposit(5);
        account.deposit(10);
        System.out.println(account);
    }

    void singleThreadDoDeposit() {
        BankAccount account = new BankAccount();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                account.deposit(1);
            }
        });

        t1.start();

        try {
            t1.join(); // Wait for t1 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account);
    }

    // No Synchronization: Possible Data Race
    // Attempts to perform deposits concurrently using two threads.
    void multiThreadDoDeposit() {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                account.deposit(1);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                account.deposit(1);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join(); // Wait for t1 to finish
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account);
    }

    void multiThreadDoSynchronizedDeposit() {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                account.depositSync(1);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                account.depositSync(1);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join(); // Wait for t1 to finish
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account);
    }

    public static void main(String[] args) {
        System.out.println("Main thread started");

        ConcurrencyDemo demo = new ConcurrencyDemo();
        // demo.create();
        // demo.joinDemo();
        // demo.sequentialDeposit();
        // demo.singleThreadDoDeposit();
        demo.multiThreadDoDeposit();
        demo.multiThreadDoSynchronizedDeposit();

        System.out.println("Main thread finished");
    }
}
