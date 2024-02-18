package dev.mayankg.design.patterns.creational.singleton.example2;

/**
 * Classic Singleton or Lazy Double-Checked Locking Singleton.
 * To solve the issue in multithreading of threads caching a value, we are using volatile keyword, but its use is only guaranteed to work only after JVM's with version 1.5 or later.
 * Volatile forces the value which is read/write from the main memory instead of cache.
 */
class LazySingleton {
    private static volatile LazySingleton INSTANCE;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (LazySingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazySingleton();
                }
            }
        }
        return INSTANCE;
    }
}