package dsa;

import java.util.NoSuchElementException;

public class StackMK {

    private final int capacity;
    private int size; // keeps availableIndex, size 1 eleman varsa bu eleman arr[0]'da olur.
    private int[] data;

    public StackMK(int capacity) {
        System.out.println("StackMK: Constructing a new instance.");
        this.size = 0;
        this.capacity = capacity;
        this.data = new int[capacity];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size >= data.length;
    }

    public void push(int n) {

        System.out.printf("push(%d): Previous capacity:%d size:%d\n", n, this.capacity, this.size);

        if (isFull()) {
            System.out.println("Insertion failed. Stack is full.");
            return;
        }

        data[this.size++] = n;
        System.out.println("Inserted: " + n);
    }

    public int pop() {
        System.out.printf("pop(): Previous capacity:%d size:%d\n", this.capacity, this.size);
        if (isEmpty()) {
            // throw new NoSuchElementException("Stack is empty.");
            System.out.println("Pop failed. Stack is empty.");
            return -1;
        }

        return data[--this.size];// 1 eleman varsa bu eleman arr[0]'da olur.
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < this.size; i++) {
            str += data[i] + " ";
        }
        return str + "] ";
    }
}
