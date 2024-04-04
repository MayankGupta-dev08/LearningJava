package dev.mayankg.dataStructures.stack;

interface MyStack {
    // Method to add an element to the queue
    void push(int item);

    // Method to remove an element from the queue
    int pop();

    // Method to check if the queue is empty
    boolean isEmpty();

    // Method to get the top element from queue
    int top();

    int size();
}