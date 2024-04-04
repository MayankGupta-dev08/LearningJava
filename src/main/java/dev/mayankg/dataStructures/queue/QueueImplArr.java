package dev.mayankg.dataStructures.queue;

/**
 * MyQueue implementation using array
 */
class QueueImplArr implements MyQueue {
    private int[] arr;
    private int size;
    private int rear;
    private int capacity;

    public QueueImplArr(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;
        this.rear = -1;
    }

    @Override
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full!! Can't add item: " + item);
            return;
        }
        this.arr[++rear] = item;
        size++;
        System.out.println(item + ": added to the queue.");
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Can't dequeue item");
            return -1;
        }
        int peek = peek();
        for (int i = 1; i < size(); i++) {
            arr[i - 1] = arr[i];
        }
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
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!!");
            return -1;
        }
        return arr[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "Queue is empty.";

        StringBuilder sb = new StringBuilder("Queue: [");
        for (int i = 0; i <= rear; i++) {
            sb.append(arr[i]);
            if (i < rear) sb.append(", ");
        }
        return sb.append("]").toString();
    }
}