package dev.mayankg.ds_algo_patterns.dataStructures.binarySearchTree;


interface BST<K extends Comparable<K>, V> {

    V get(K key);
    void put(K key, V value);
    void delete(K key);
    int size();
    K min();
    K max();
    K floor(K key);
    K ceil(K key);
    int rank(K key);

}