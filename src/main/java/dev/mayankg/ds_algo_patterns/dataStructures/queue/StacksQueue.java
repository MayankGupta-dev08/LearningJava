package dev.mayankg.ds_algo_patterns.dataStructures.queue;

import java.util.Stack;

/**
 * Using O(n) approach for push and O(1) for peek and dequeue
 */
@SuppressWarnings({"unused"})
class StacksQueue<T> implements MyQueue<T> {
    private Stack<T> s1;    // main stack
    private Stack<T> s2;    // helper stack

    public StacksQueue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    @Override
    public void enqueue(T item) {
        if (s1.isEmpty()) {
            s1.add(item);
        } else {
            while (!s1.isEmpty()) s2.add(s1.pop());
            s1.add(item);
            while (!s2.isEmpty()) s1.add(s2.pop());
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Empty Queue!");
        return s1.pop();
    }

    @Override
    public boolean isEmpty() {
        return s1.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public T peek() {
        if (s1.isEmpty())
            throw new IllegalStateException("Empty Queue!");
        return s1.peek();
    }

    @Override
    public int size() {
        return s1.size();
    }

    @Override
    public void clear() {
        while (!s1.isEmpty())
            s1.pop();
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "Queue is empty!";

        StringBuilder sb = new StringBuilder("[");
        for (int i = s1.size() - 1; i >= 0; i--) {
            sb.append(s1.get(i));
            if (i != 0) sb.append(", ");
        }
        return sb.append("]").toString();
    }
}