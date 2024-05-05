package dev.mayankg.design.patterns.creational.singleton.lazy.static_holder;

/**
 * Singleton using Lazy Initialization Holder Class. To implement lazy initialization, w/o worrying about synchronization.
 * The JVM guarantees that a class will only be loaded and initialized once, at the time of its first usage. The static inner class RegistryHolder is not loaded until the
 * getInstance() method is called. The Java class loading mechanism ensures that a class is loaded by only one class loader in a JVM. When a class is loaded, its static initializers are executed in a thread-safe manner by the JVM.
 */
class LazySingletonIH {
    // Lazy Initialisation on Demand Holder Idiom
    private LazySingletonIH() {
        System.out.println("Initialized LazySingletonIH object");
    }

    public static LazySingletonIH getInstance() {
        return RegistryHolder.INSTANCE;
    }

    /**
     * private static class just for holding and creating a single instance of LazySingletonIH and since its inner static class,
     * Also, it's not loaded by the class loader before its actually externally accessed by any other class using the getInstance() of LazySingletonIH class.
     */
    private static class RegistryHolder {
        private static final LazySingletonIH INSTANCE = new LazySingletonIH();
    }
}