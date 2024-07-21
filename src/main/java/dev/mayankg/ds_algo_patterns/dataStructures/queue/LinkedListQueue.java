package dev.mayankg.ds_algo_patterns.dataStructures.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Queue implementation using LinkedList
 */
@SuppressWarnings({"unused"})
class LinkedListQueue<T> implements MyQueue<T>, Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void enqueue(T item) {
        Node<T> node = new Node<>(item);
        if (isEmpty()) {
            tail = head = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Empty Queue!");

        T front = head.val;
        if (head == tail) {
            tail = null;  // single node remaining
        }
        head = head.next;   // move head to next node (null for last node)
        size--;
        return front;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean isFull() {
        return false;  // linked list is never full
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new IllegalStateException("Empty Queue!");

        return head.val;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "Queue is empty.";

        StringBuilder sb = new StringBuilder("[");
        Node<T> temp = head;
        while (temp != null) {
            sb.append(temp.val);
            if (temp.next != null) sb.append(", ");
            temp = temp.next;
        }
        return sb.append("]").toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                T value = current.val;
                current = current.next;
                return value;
            }
        };
    }

    static class Node<T> {
        T val;
        Node<T> next;

        public Node(T val) {
            this.val = val;
            this.next = null;
        }
    }
}