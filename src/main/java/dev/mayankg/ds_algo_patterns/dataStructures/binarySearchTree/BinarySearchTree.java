package dev.mayankg.ds_algo_patterns.dataStructures.binarySearchTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Search Tree
 *
 * @param <K> Key, must be comparable
 * @param <V> Value associated with the key
 * @see Node Node<K, V> such that we can't have duplicate keys
 */
@SuppressWarnings({"unused"})
class BinarySearchTree<K extends Comparable<K>, V> implements BST<K, V>, Iterable<K> {
    private Node<K, V> root;

    /**
     * Search for a key in the binary search tree <br>
     * Time Complexity: O(log n) <br>
     * If less, go left; if greater, go right; if equal, return value; if not found, return null
     *
     * @param key key of the node
     * @return Value associated with the key
     */
    @Override
    public V get(K key) {
        Node<K, V> node = root;

        while (node != null) {
            int comp = key.compareTo(node.getKey());
            if (comp < 0) node = node.getLeft();
            else if (comp > 0) node = node.getRight();
            else return node.getValue();
        }

        return null;
    }

    /**
     * Number of nodes in the binary search tree
     *
     * @return Number of nodes in the binary search tree
     */
    @Override
    public int size() {
        return size(root);
    }

    private int size(Node<K, V> node) {
        return node == null ? 0 : node.getCount();
    }

    /**
     * If key is already present, update the value; else insert a new node <br>
     * Time Complexity: O(log n) <br>
     * If less, go left; if greater, go right; if equal, update value; if not found, insert new node
     *
     * @param key   key of the node
     * @param value value associated with the key
     */
    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node<K, V> put(Node<K, V> node, K key, V value) {
        if (node == null) return new Node<>(key, value, 1);

        int comp = key.compareTo(node.getKey());
        if (comp < 0)
            node.setLeft(put(node.getLeft(), key, value));
        else if (comp > 0)
            node.setRight(put(node.getRight(), key, value));
        else
            node.setValue(value);

        node.setCount(1 + size(node.getLeft()) + size(node.getRight()));
        return node;
    }

    @Override
    public K min() {
        if (root == null) return null;
        return min(root).getKey();
    }

    private Node<K, V> min(Node<K, V> node) {
        if (node.getLeft() == null) return node;
        return min(node.getLeft());
    }

    @Override
    public K max() {
        if (root == null) return null;
        return max(root).getKey();
    }

    private Node<K, V> max(Node<K, V> node) {
        if (node.getRight() == null) return node;
        return max(node.getRight());
    }

    @Override
    public void delete(K key) {
        root = delete(root, key);
    }

    private Node<K, V> delete(Node<K, V> node, K key) {
        if (node == null) return null;

        int comp = key.compareTo(node.getKey());
        if (comp < 0)
            node.setLeft(delete(node.getLeft(), key));
        else if (comp > 0)
            node.setRight(delete(node.getRight(), key));
        else {
            if (node.getRight() == null) return node.getLeft();
            if (node.getLeft() == null) return node.getRight();

            Node<K, V> temp = node;
            node = min(temp.getRight());
            node.setRight(deleteMin(temp.getRight()));
            node.setLeft(temp.getLeft());
        }

        node.setCount(1 + size(node.getLeft()) + size(node.getRight()));
        return node;
    }

    private Node<K, V> deleteMin(Node<K, V> node) {
        if (node.getLeft() == null) return node.getRight();
        node.setLeft(deleteMin(node.getLeft()));
        node.setCount(1 + size(node.getLeft()) + size(node.getRight()));
        return node;
    }

    /**
     * Floor of a key is the largest key in the binary search tree that is less than or equal to the given key <br>
     * Time Complexity: O(log n) <br>
     */
    @Override
    public K floor(K key) {
        Node<K, V> node = floor(root, key);
        return node == null ? null : node.getKey();
    }

    private Node<K, V> floor(Node<K, V> node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.getKey());
        if (cmp == 0) return node;
        if (cmp < 0) return floor(node.getLeft(), key);
        Node<K, V> temp = floor(node.getRight(), key);
        return temp != null ? temp : node;
    }

    /**
     * Ceil of a key is the smallest key in the binary search tree that is greater than or equal to the given key <br>
     * Time Complexity: O(log n) <br>
     */
    @Override
    public K ceil(K key) {
        Node<K, V> node = ceil(root, key);
        return node == null ? null : node.getKey();
    }

    private Node<K, V> ceil(Node<K, V> node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.getKey());
        if (cmp == 0) return node;
        if (cmp > 0) return ceil(node.getRight(), key);
        Node<K, V> temp = ceil(node.getLeft(), key);
        return temp != null ? temp : node;
    }

    /**
     * Rank of a key is the number of keys in the binary search tree that are less than the given key <br>
     * Time Complexity: O(log n) <br>
     */
    @Override
    public int rank(K key) {
        return rank(root, key);
    }

    private int rank(Node<K, V> node, K key) {
        if (node == null) return 0;
        int cmp = key.compareTo(node.getKey());
        if (cmp < 0) return rank(node.getLeft(), key);
        if (cmp > 0) return 1 + size(node.getLeft()) + rank(node.getRight(), key);
        return size(node.getLeft());
    }

    @Override
    public Iterator<K> iterator() {
        return keys().iterator();
    }

    public Iterable<K> keys() {
        Queue<K> q = new LinkedList<>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node<K, V> node, Queue<K> q) {
        if (node == null) return;
        inorder(node.getLeft(), q);
        q.add(node.getKey());
        inorder(node.getRight(), q);
    }
}