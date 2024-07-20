package dev.mayankg.ds_algo_patterns.dataStructures.stack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Stack implementation using ArrayList
 */
class ArrayListStack<T> implements MyStack<T> {
    private ArrayList<T> al;
    private int top;    // pointer (index) on the ArrayList for getting the top of stack

    public ArrayListStack() {
        al = new ArrayList<>();
        top = -1;
    }

    @Override
    public void push(T item) {
        al.add(item);
        top++;
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack is empty!!");
        return al.remove(top--);
    }

    @Override
    public boolean isEmpty() {
        return al.isEmpty();
    }

    @Override
    public T top() {
        if (isEmpty())
            throw new NoSuchElementException("Stack is empty!!");
        return al.get(top);
    }

    @Override
    public int size() {
        return al.size();
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "Stack is empty!!";

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            sb.append(al.get(i));
            if (i != top) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    @Override
    public void clear() {
        if (isEmpty()) return;
        al.clear();
        top = -1;
    }
}