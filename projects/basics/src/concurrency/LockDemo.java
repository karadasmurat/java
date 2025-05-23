package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            // critical section
        } finally {
            lock.unlock(); // MUST release
        }

        var myLock = new ReentrantLock();
        Thread.ofPlatform().start(() -> System.out.println("Hello"));
        if (myLock.tryLock()) {
            try {
                System.out.println("Lock obtained, entering protected code");
            } finally {
                myLock.unlock();
            }
        } else {
            System.out.println("Unable to acquire lock, doing something else");
        }
    }
}





