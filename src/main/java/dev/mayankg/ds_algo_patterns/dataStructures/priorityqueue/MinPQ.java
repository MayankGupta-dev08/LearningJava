package dev.mayankg.ds_algo_patterns.dataStructures.priorityqueue;

interface MinPQ<T extends Comparable<T>> {
    void insert(T item);
    T delMin();
    boolean isEmpty();
    int size();
    T min();
}
