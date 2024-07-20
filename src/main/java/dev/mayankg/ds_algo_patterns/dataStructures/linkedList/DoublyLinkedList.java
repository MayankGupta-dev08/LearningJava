package dev.mayankg.ds_algo_patterns.dataStructures.linkedList;

import dev.mayankg.ds_algo_patterns.dataStructures.util.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Node has val, next and prev. <br>
 * Doubly Linked List with head and tail nodes.
 */
@SuppressWarnings({"unused"})
class DoublyLinkedList<T> implements MyLinkedList<T>, Iterable<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    @Override
    public void addFirst(T item) {
        Node<T> node = new Node<>(item);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        Node<T> node = new Node<>(item);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("LinkedList is empty!!");

        T data = head.val;
        if (size == 1)
            head = tail = null;
        else {
            Node<T> newHead = head.next;
            newHead.prev = null;
            head.next = null;
            head = newHead;
        }
        size--;
        return data;
    }

    @Override
    public T removeLast() {
        if (isEmpty())
            throw new NoSuchElementException("LinkedList is empty!!");

        T data = tail.val;
        if (size == 1) {
            head = tail = null;
        } else {
            Node<T> temp = tail.prev;
            temp.next = null;
            tail.prev = null;
            tail = temp;
        }
        size--;
        return data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T first() {
        if (isEmpty()) return null;
        return head.val;
    }

    @Override
    public T last() {
        if (isEmpty()) return null;
        return tail.val;
    }

    @Override
    public T get(int idx) {
        Node<T> node = getNode(idx);
        return node != null ? node.val : null;
    }

    // Package-private method for testing purposes only
    Node<T> getNode(int idx) {
        if (idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException();

        Node<T> currNode = head;
        int counter = 0;
        while (currNode != null && counter != idx) {
            currNode = currNode.next;
            counter++;
        }
        return currNode;
    }

    @Override
    public void remove(int idx) {
        if (idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException();

        if (idx == 0) {
            removeFirst();
        } else if (idx == size - 1) {
            removeLast();
        } else {
            Node<T> temp = head;
            for (int i = 0; i < idx - 1; i++)
                temp = temp.next;

            Node<T> newNext = temp.next.next;
            temp.next = newNext;
            newNext.prev = temp;
            size--;
        }
    }

    @Override
    public void insert(int idx, T item) {
        if (idx < 0 || idx > size)
            throw new IndexOutOfBoundsException();

        if (idx == 0) {
            addFirst(item);
        } else if (idx == size) {
            addLast(item);
        } else {
            Node<T> temp = head;
            Node<T> node = new Node<>(item);
            for (int i = 0; i < idx - 1; i++)
                temp = temp.next;

            node.next = temp.next;
            temp.next.prev = node;
            temp.next = node;
            node.prev = temp;
            size++;
        }
    }

    @Override
    public void clear() {
        Node<T> curr = head;
        while (curr != null) {
            Node<T> nxt = curr.next;
            curr.val = null;
            curr.next = null;
            curr.prev = null;
            curr = nxt;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        return sb.append("]").toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException();

                T value = currentNode.val;
                currentNode = currentNode.next;
                return value;
            }
        };
    }

    // Package-private getters for testing purposes
    Node<T> getHead() {
        return head;
    }

    Node<T> getTail() {
        return tail;
    }
}