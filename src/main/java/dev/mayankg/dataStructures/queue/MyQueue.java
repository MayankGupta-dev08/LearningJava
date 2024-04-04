package dev.mayankg.dataStructures.queue;

interface MyQueue {
    // Method to add an element to the queue
    void enqueue(int item);

    // Method to remove an element from the queue
    int dequeue();

    // Method to check if the queue is empty
    boolean isEmpty();

    // Method to check if the queue is full
    boolean isFull();

    // Method to get the top element from queue
    int peek();

    int size();
}