package dev.mayankg.ds_algo_patterns.dataStructures.hashtable;

import java.util.List;

public interface HashTableI<K, V> {
    int size();
    boolean isEmpty();
    void clear();
    boolean containsKey(K key);
    V put(K key, V value);
    V add(K key, V value);
    V insert(K key, V value);
    V get(K key);
    V remove(K key);
    List<K> keys();
    List<V> values();
}