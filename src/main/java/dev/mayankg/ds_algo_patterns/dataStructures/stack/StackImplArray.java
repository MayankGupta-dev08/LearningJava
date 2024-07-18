package dev.mayankg.ds_algo_patterns.dataStructures.stack;

import dev.mayankg.dataStructures.stack.MyStack;

import java.util.NoSuchElementException;

class StackImplArray implements dev.mayankg.dataStructures.stack.MyStack {
    private int[] arr;
    private int top;
    private int capacity;

    public StackImplArray(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.top = -1;
    }

    @Override
    public void push(int item) {
        if (isFull())
            throw new IllegalStateException("Stack Overflow!!");

        arr[++top] = item;
    }

    @Override
    public int pop() {
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
    public int top() {
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

        StringBuilder sb = new StringBuilder("Stack: [");
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