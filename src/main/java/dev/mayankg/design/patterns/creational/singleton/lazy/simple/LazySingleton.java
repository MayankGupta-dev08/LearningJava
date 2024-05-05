package dev.mayankg.design.patterns.creational.singleton.lazy.simple;

/**
 * Simple Lazy Initialisation of Singleton Pattern
 */
class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}