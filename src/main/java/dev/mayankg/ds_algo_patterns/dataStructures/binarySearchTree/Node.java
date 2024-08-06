package dev.mayankg.ds_algo_patterns.dataStructures.binarySearchTree;

/**
 * Node of a binary search tree <br>
 */
class Node<K extends Comparable<K>, V> {
    private K key;
    private V value;
    private Node<K, V> left;
    private Node<K, V> right;
    private int count;  // Number of nodes in the subtree rooted at this node (including this node)

    private Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Node(K key, V value, int count) {
        this(key, value);
        this.count = count;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<K, V> getLeft() {
        return left;
    }

    public void setLeft(Node<K, V> left) {
        this.left = left;
    }

    public Node<K, V> getRight() {
        return right;
    }

    public void setRight(Node<K, V> right) {
        this.right = right;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
