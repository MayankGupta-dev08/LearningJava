package dev.mayankg.ds_algo_patterns.dataStructures.queue;

interface MyQueue<T> {

    void enqueue(T item); // Method to add an element to the queue
    T dequeue();  // Method to remove an element from the queue
    T peek(); // Method to get the top element from queue
    boolean isEmpty();  // Method to check if the queue is empty
    boolean isFull();   // Method to check if the queue is full
    int size();
    void clear();

}