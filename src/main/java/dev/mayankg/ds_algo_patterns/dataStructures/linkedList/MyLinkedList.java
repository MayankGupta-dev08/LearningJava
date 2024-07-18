package dev.mayankg.ds_algo_patterns.dataStructures.linkedList;

interface MyLinkedList<T> {
    void addFirst(T item);

    void addLast(T item);

    void removeFirst();

    void removeLast();

    int getSize();

    boolean isEmpty();

    T peek();

    default void add(T item) {
        addLast(item);
    }

    default void remove() {
        removeLast();
    }

    void remove(int idx);

    void insert(int idx, T item);
}