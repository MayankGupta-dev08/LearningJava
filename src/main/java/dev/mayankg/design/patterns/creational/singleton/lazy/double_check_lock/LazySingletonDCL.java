package dev.mayankg.design.patterns.creational.singleton.lazy.double_check_lock;

/**
 * Classic Singleton or Lazy Double-Checked Locking Singleton.
 * To solve the issue in multithreading of threads caching a value, we are using volatile keyword, but its use is only guaranteed to work only after JVM's with version 1.5 or later.
 * Volatile forces the value which is read/write from the main memory instead of cache.
 */
class LazySingletonDCL {
    private static volatile LazySingletonDCL instance;

    private LazySingletonDCL() {}

    public static LazySingletonDCL getInstance() {
        if (instance == null) {
            synchronized (LazySingletonDCL.class) {
                if (instance == null) {
                    instance = new LazySingletonDCL();
                }
            }
        }
        return instance;
    }
}