package dev.mayankg.design.patterns.structural.bridge.example;

/**
 * This is the implementor.
 * As implementor is defining its own hierarchy, which is not related at all to the abstraction hierarchy.
 */
interface LinkedList<T> {
    void addFirst(T element);

    T removeFirst();

    void addLast(T element);

    T removeLast();

    int getSize();
}