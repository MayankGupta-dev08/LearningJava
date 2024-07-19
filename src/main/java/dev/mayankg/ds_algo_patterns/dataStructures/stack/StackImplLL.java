package dev.mayankg.ds_algo_patterns.dataStructures.stack;

import java.util.NoSuchElementException;


/**
 * Stack implementation using LinkedList
 */
class StackImplLL implements MyStack {
    private Node head;
    private int size = 0;

    @Override
    public void push(int item) {
        Node node = new Node(item);
        size++;
        if (isEmpty()) {
            head = node;
            return;
        }
        node.prev = head;
        head = node;
    }

    @Override
    public int pop() {
        if (isEmpty())
            return -1;

        int top = head.val;
        head = head.prev;
        size--;
        return top;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int top() {
        if (isEmpty())
            throw new NoSuchElementException("Stack is empty!!");
        return head.val;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "Stack is empty!!";

        StringBuilder sb = new StringBuilder("Stack: [");
        for (Node temp = head; temp != null; temp = temp.prev) {
            sb.append(temp.val);
            if (temp.prev != null) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    static class Node {
        int val;
        Node prev;

        public Node(int val) {
            this.val = val;
        }
    }
}