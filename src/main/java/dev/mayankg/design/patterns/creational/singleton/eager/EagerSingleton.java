package dev.mayankg.design.patterns.creational.singleton.eager;

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