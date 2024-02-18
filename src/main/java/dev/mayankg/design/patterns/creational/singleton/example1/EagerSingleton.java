package dev.mayankg.design.patterns.creational.singleton.example1;

/**
 * Eager Initialisation of Singleton Pattern
 */
class EagerSingleton {
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}