package concurrency;

public class SynchronizedCounter {
    private int cnt = 0;

    public synchronized void increment() {
        cnt++;
        System.out.println("Incremented: " + cnt);
    }

    public synchronized void decrement() {
        cnt--;
        System.out.println("Decremented: " + cnt);
    }

    public synchronized int value() {
        return cnt;
    }
}
