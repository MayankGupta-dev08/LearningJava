package dev.mayankg.ds_algo_patterns.dataStructures.util;

public class Node<T> {
    T val;
    Node<T> next;

    public Node(T val) {
        this.val = val;
    }

    public Node(T val, Node<T> next) {
        this.val = val;
        this.next = next;
    }
}