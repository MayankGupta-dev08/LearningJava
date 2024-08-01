package dev.mayankg.ds_algo_patterns.dataStructures.priorityqueue;

interface MaxPQ<T extends Comparable<T>> {
    void insert(T item);
    T delMax();
    boolean isEmpty();
    int size();
    T max();
}
