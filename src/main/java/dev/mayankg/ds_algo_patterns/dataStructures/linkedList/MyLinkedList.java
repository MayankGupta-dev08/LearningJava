package dev.mayankg.ds_algo_patterns.dataStructures.linkedList;

interface MyLinkedList<T> {

    int size();
    boolean isEmpty();
    void addFirst(T item);
    void addLast(T item);
    void removeFirst();
    void removeLast();
    void remove(int idx);
    void insert(int idx, T item);
    T first();
    T last();
    T get(int idx);
    void clear();

    default void add(T item) {
        addLast(item);
    }

    default void remove() {
        removeLast();
    }
}