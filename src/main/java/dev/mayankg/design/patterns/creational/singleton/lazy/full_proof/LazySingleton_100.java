package dev.mayankg.design.patterns.creational.singleton.lazy.full_proof;

import java.io.Serializable;

class LazySingleton_100 extends ABCWork implements Serializable {

    /**
     * To prevent new instance creation while using constructor from reflection api
     */
    private LazySingleton_100() throws IllegalAccessException {
        if (getInstance() != null)
            throw new IllegalAccessException("Object can't be created using Java Reflection API.");
    }

    public static LazySingleton_100 getInstance() {
        return RegistryHolder.instance;
    }

    /**
     * To prevent new instance creation while cloning
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    /**
     * To prevent new instance creation while serialization-deserialization
     */
    protected Object readResolve() {
        return getInstance();
    }

    private static class RegistryHolder {
        private static final LazySingleton_100 instance;

        static {
            try {
                instance = new LazySingleton_100();
            } catch (IllegalAccessException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}