package dev.mayankg.ds_algo_patterns.dataStructures.util;

public class Node<T> {
    public T val;
    public Node<T> next;
    public Node<T> prev;

    public Node(T val) {
        this.val = val;
    }

    public Node(T val, Node<T> next, Node<T> prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return val.toString();
    }
}