package dev.mayankg.dataStructures.queue;

class CircularQueueImpl implements MyQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueueImpl(int capacity) {
        this.capacity = capacity;
        this.front = -1;
        this.rear = -1;
        this.arr = new int[capacity];
        this.size = 0;
    }

    @Override
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full! Can't add item: " + item);
            return;
        }

        if (isEmpty()) front = 0;

        rear = (rear + 1) % capacity;
        arr[rear] = item;
        size++;
        System.out.println(item + ": added to the queue.");
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Can't delete.");
            return -1;
        }

        int removedItem = arr[front];
        if (front == rear)
            front = rear = -1;
        else
            front = (front + 1) % capacity;

        size--;
        return removedItem;
    }

    @Override
    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    @Override
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot peek.");
            return -1;
        }
        return arr[front];
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