package dev.mayankg.caching;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU Cache implementation using HashMap and Doubly Linked List
 */
public class LRUCache<T> implements Cache<T> {
    private final int capacity;
    private final Map<String, Node> entryMap;
    private final DoublyLinkedList internalQueue;
    private int size;

    public LRUCache(final int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.entryMap = new HashMap<>(capacity);
        this.internalQueue = new DoublyLinkedList();
    }

    /**
     * Fetching the value for the key and if found also moving it to the front in the queue
     */
    @Override
    public T get(final String key) {
        Node node = entryMap.get(key);
        if (node == null) return null;

        internalQueue.moveNodeToFront(node);
        return (T) node.value;
    }

    /**
     * Adding the key-value pair to the cache:
     * <ol>
     * 1. If the key already exists, update the value and move the node to the front. <br>
     * 2. If the key doesn't exist, add the key-value pair to the cache <br>
     * 2.1 Check if the cache is full, remove the last node from the cache <br>
     * 2.2 add the new node to the front. <br>
     * </ol>
     */
    @Override
    public void put(final String key, final T value) {
        Node existingNode = entryMap.get(key);
        if (existingNode != null) {
            existingNode.value = value;
            internalQueue.moveNodeToFront(existingNode);
            return;
        }

        if (size == capacity) {
            Node lastNode = internalQueue.removeLast();
            entryMap.remove(lastNode.key);
            size--;
        }

        Node newNode = new Node(key, value);
        internalQueue.addFirst(newNode);
        entryMap.put(key, newNode);
        size++;
    }

    /**
     * Remove the key from the cache
     */
    @Override
    public void remove(String key) {
        Node node = entryMap.get(key);
        if (node == null) return;

        internalQueue.remove(node);
        entryMap.remove(key);
        size--;
    }

    /**
     * Clear the cache
     */
    @Override
    public void clear() {
        entryMap.clear();
        internalQueue.head = null;
        internalQueue.tail = null;
        size = 0;
    }

    public int size() {
        return this.size;
    }

    private class Node<T> {
        private String key;
        private T value;
        private Node<T> next;
        private Node<T> prev;

        public Node(final String key, final T value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    private class DoublyLinkedList<T> {
        private Node<T> head;
        private Node<T> tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        /**
         * Time Complexity: O(1)
         */
        public void addFirst(final Node<T> node) {
            if (head == null) {
                head = tail = node;
                return;
            }

            node.next = head;
            head.prev = node;
            head = node;
        }

        /**
         * Time Complexity: O(1)
         */
        public void remove(final Node<T> node) {
            if (node == null) return;

            if (node == head) {
                head = head.next;
            } else if (node == tail) {
                tail = tail.prev;
                tail.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }

        /**
         * Time Complexity: O(1)
         */
        public Node<T> removeLast() {
            if (tail == null) return null;

            Node<T> lastNode = tail;
            remove(tail);
            return lastNode;
        }

        /**
         * Time Complexity: O(1)
         * Move the node to the front of the queue involves:
         * <ol>
         *     1. removing the node from the current position <br>
         *     2. adding it to the front.
         *  </ol>
         */
        public void moveNodeToFront(final Node<T> node) {
            if (node == head) return;

            remove(node);
            addFirst(node);
        }
    }
}
