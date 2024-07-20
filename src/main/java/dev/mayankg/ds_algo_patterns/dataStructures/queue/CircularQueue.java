package dev.mayankg.ds_algo_patterns.dataStructures.queue;

/**
 * Circular Queue implementation using Array
 */
@SuppressWarnings({"unused", "unchecked"})
class CircularQueue<T> implements MyQueue<T> {
    private T[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueue(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Capacity must be greater than zero");

        this.capacity = capacity;
        this.front = -1;
        this.rear = -1;
        this.arr = (T[]) new Object[capacity];
        this.size = 0;
    }

    @Override
    public void enqueue(T item) {
        if (isFull())
            throw new IllegalStateException("Queue is full!");

        if (isEmpty()) front = 0;

        rear = (rear + 1) % capacity;
        arr[rear] = item;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Empty Queue");

        T removedItem = arr[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }

        size--;
        return removedItem;
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
            throw new IllegalStateException("Empty Queue");

        return arr[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "Queue is empty.";

        StringBuilder sb = new StringBuilder("[");
        int i = front;
        int count = 0;
        while (count < size) {
            sb.append(arr[i]);
            if (count < size - 1) {
                sb.append(", ");
            }
            i = (i + 1) % capacity;
            count++;
        }
        sb.append("]");
        return sb.toString();
    }
}