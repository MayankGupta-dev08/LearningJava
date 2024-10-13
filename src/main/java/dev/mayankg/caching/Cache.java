package dev.mayankg.caching;

public interface Cache<T> {
    void put(String key, T value);

    T get(String key);

    void remove(String key);

    void clear();
}
