package dev.mayankg.multithreading;

class MyStack {
    private int stackTop;
    private int[] array;
    private Object lock;

    MyStack(int capacity) {
        stackTop = -1;
        array = new int[capacity];
        lock = new Object();
    }

    boolean push(int element) {
        synchronized (lock) {
            if (isFull()) return false;
            stackTop++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            array[stackTop] = element;
            return true;
        }
    }

    int pop() {
        synchronized (lock) {
            if (isEmpty()) return Integer.MIN_VALUE;
            int popped_elem = array[stackTop];
            array[stackTop] = Integer.MIN_VALUE;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            stackTop--;
            return popped_elem;
        }
    }

    boolean isEmpty() {
        return stackTop < 0;
    }

    boolean isFull() {
        return stackTop == array.length - 1;
    }
}