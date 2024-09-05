package dev.mayankg.ds_algo_patterns.dataStructures.binarySearchTree;

import java.util.Iterator;

/**
 * Red-Black Tree aka Left Leaning Red-Black BST <br>
 * Properties: <br>
 * 1. Every node is either red or black <br>
 * 2. Root is black <br>
 * 3. Every leaf (NIL) is black <br>
 * 4. Represents a 2-3 tree as a BST <br>
 * 5. Red link must lean left <br>
 * 6. No node has two red links connected to it <br>
 * 7. Every path from root to leaf has the same number of black links <br>
 *
 * @param <K> Key, must be comparable
 * @param <V> Value associated with the key
 * @see Node Node<K, V> such that we can't have duplicate keys
 */
public class RedBlackTree<K extends Comparable<K>, V> implements BST<K, V>, Iterable<K> {

    private Node<K, V> root;

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public void delete(K key) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public K min() {
        return null;
    }

    @Override
    public K max() {
        return null;
    }

    @Override
    public K floor(K key) {
        return null;
    }

    @Override
    public K ceil(K key) {
        return null;
    }

    @Override
    public int rank(K key) {
        return 0;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    private class Node<K extends Comparable<K>, V> {
        private K key;
        private V value;
        private Node<K, V> left, right;
        private boolean color;
        private int count;

        public Node(K key, V value, boolean color, int count) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.count = count;
        }
    }
}
