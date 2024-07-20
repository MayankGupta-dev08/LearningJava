package dev.mayankg.ds_algo_patterns.dataStructures.queue;

import java.util.NoSuchElementException;

/**
 * MyQueue implementation using array
 */
@SuppressWarnings({"unused", "unchecked"})
class ArrayQueue<T> implements MyQueue<T> {
    private T[] arr;
    private int size;
    private int rear;
    private int capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
        this.size = 0;
        this.rear = -1;
    }

    @Override
    public void enqueue(T item) {
        if (isFull())
            throw new IllegalStateException("Queue is full!");

        this.arr[++rear] = item;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty!");

        T peek = peek();
        for (int i = 1; i < size(); i++)
            arr[i - 1] = arr[i];

        rear--;
        size--;
        return peek;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty!");
        return arr[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            arr[i] = null;

        size = 0;
        rear = -1;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "Queue is empty!";

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= rear; i++) {
            sb.append(arr[i]);
            if (i < rear) sb.append(", ");
        }
        return sb.append("]").toString();
    }
}