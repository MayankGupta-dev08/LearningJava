package dev.mayankg.design.patterns.creational.abstractfactory.example.common;

/**
 * Abstract Product1
 */
public interface Instance {
    void start();

    void attachStorage(Storage storage);

    void stop();

    enum Capacity {micro, small, large}
}