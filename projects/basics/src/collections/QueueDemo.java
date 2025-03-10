package collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public void declareAndInitialize() {

        Queue<String> queue = new LinkedList<>();

        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");

        String first = queue.poll();
        System.out.println("First: " + first);
    }

    public static void main(String[] args) {

        QueueDemo demo = new QueueDemo();
        demo.declareAndInitialize();

    }

}
