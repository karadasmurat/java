package mk;

interface Selector {
    boolean end();

    Object current();

    void next();
}
// The Sequence is simply a fixed-sized array of Object with a class wrapped
// around it.

public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    // add a new Object to the end of the sequence (if there’s room left).
    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }

    // A private inner class that provides Selector functionality.
    // Notice that its methods directly access a private field in the enclosing class (items)
    private class SequenceSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == items.length;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if (i < items.length)
                i++;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {

        // create a Sequence, and add of a number of String objects.
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
