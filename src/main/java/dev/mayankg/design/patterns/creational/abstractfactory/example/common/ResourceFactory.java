package dev.mayankg.design.patterns.creational.abstractfactory.example.common;

/**
 * Abstract Factory for creating both the objects with abstract form
 */
public interface ResourceFactory {
    Instance createInstance(Instance.Capacity capacity);

    Storage createStorage(int capMib);
}