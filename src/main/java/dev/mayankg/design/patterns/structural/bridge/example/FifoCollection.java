package dev.mayankg.design.patterns.structural.bridge.example;

/**
 * This is the abstraction.
 */
interface FifoCollection<T> {
    void offer(T element);

    T poll();

}