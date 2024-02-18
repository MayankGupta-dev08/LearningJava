package dev.mayankg.design.patterns.creational.singleton.example3;

/**
 * Singleton using Lazy Initialization Holder Class. To implement lazy initialization, w/o worrying about synchronization.
 * The JVM guarantees that a class will only be loaded and initialized once, at the time of its first usage. The static inner class RegistryHolder is not loaded until the
 * getInstance() method is called. The Java class loading mechanism ensures that a class is loaded by only one class loader in a JVM. When a class is loaded, its static initializers are executed in a thread-safe manner by the JVM.
 */
class LazySingletonIH {
    private LazySingletonIH() {
        System.out.println("Initialized LazySingletonIH object");
    }

    public static LazySingletonIH getInstance() {
        return RegistryHolder.INSTANCE;
    }

    private static class RegistryHolder {
        static LazySingletonIH INSTANCE = new LazySingletonIH();

    }
}