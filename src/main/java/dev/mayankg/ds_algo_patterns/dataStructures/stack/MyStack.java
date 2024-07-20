package dev.mayankg.ds_algo_patterns.dataStructures.stack;

interface MyStack<T> {

    void push(T item);     // Method to add an element to the queue
    T pop();  // Method to remove an element from the queue
    T top();  // Method to get the top element from queue
    int size();
    boolean isEmpty();  // Method to check if the queue is empty
    void clear();

    default boolean isFull() {
        return false;
    }
}