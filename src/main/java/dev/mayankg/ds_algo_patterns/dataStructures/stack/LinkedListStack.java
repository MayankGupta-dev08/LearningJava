package dev.mayankg.ds_algo_patterns.dataStructures.stack;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Stack implementation using LinkedList
 */
class LinkedListStack<T> implements MyStack<T>, Iterable<T> {
    private Node<T> head = null;
    private int size = 0;

    @Override
    public void push(T item) {
        Node<T> node = new Node<>(item);
        if (!isEmpty()) {
            head.prev = node;
            node.next = head;
        }
        head = node;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();

        T top = head.val;
        head = head.next;
        if (head != null) head.prev = null;
        size--;
        return top;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T top() {
        if (isEmpty())
            throw new EmptyStackException();
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
            return "Stack is empty!";

        StringBuilder sb = new StringBuilder("[");
        for (Node<T> temp = head; temp != null; temp = temp.next) {
            sb.append(temp.val);
            if (temp.next != null) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> topNode = head;

            @Override
            public boolean hasNext() {
                return topNode != null;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new EmptyStackException();

                T data = topNode.val;
                topNode = topNode.next;
                return data;
            }
        };
    }

    static class Node<T> {
        T val;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T val) {
            this.val = val;
        }
    }
}