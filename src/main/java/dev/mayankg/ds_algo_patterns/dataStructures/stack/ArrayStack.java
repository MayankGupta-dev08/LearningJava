package dev.mayankg.ds_algo_patterns.dataStructures.stack;

import java.util.NoSuchElementException;

/**
 * Stack implementation using Array
 */
@SuppressWarnings({"unused", "unchecked"})
class ArrayStack<T> implements MyStack<T> {
    private T[] arr;
    private int top;    // pointer (index) on the ArrayList for getting the top of stack
    private int capacity;   // actual capacity of the array

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
        this.top = -1;
    }

    @Override
    public void push(T item) {
        if (isFull())
            throw new IllegalStateException("Stack Overflow!!");

        arr[++top] = item;
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack is empty");

        return arr[top--];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == capacity - 1;
    }

    @Override
    public T top() {
        if (isEmpty())
            throw new NoSuchElementException("Stack is empty!!");

        return arr[top];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "Stack is empty!!";

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            sb.append(arr[i]);
            if (i != top) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    @Override
    public void clear() {
        if (isEmpty()) return;
        while (!isEmpty())
            top--;
    }
}