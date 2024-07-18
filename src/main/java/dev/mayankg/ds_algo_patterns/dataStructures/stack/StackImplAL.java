package dev.mayankg.ds_algo_patterns.dataStructures.stack;

import dev.mayankg.dataStructures.stack.MyStack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Stack implementation using ArrayList
 */
class StackImplAL implements dev.mayankg.dataStructures.stack.MyStack {
    private ArrayList<Integer> al;
    private int top;

    public StackImplAL() {
        al = new ArrayList<>();
        top = -1;
    }

    @Override
    public void push(int item) {
        top++;
        al.add(item);
    }

    @Override
    public int pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack is empty!!");
        return al.remove(top--);
    }

    @Override
    public boolean isEmpty() {
        return al.isEmpty();
    }

    @Override
    public int top() {
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

        StringBuilder sb = new StringBuilder("Stack: [");
        for (int i = 0; i <= top; i++) {
            sb.append(al.get(i));
            if (i != top) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    @Override
    public void clear() {
        if (isEmpty()) return;
        while (!isEmpty()) pop();
    }
}