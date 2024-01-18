package dev.mayankg.generics;

/**
 * Utility Class which itself is not generic but its methods are generic.
 */

class Utils {
    static <T extends Comparable<T>> T min(T first, T second) {
        return (first.compareTo(second) < 0) ? first : second;
    }

    static <T extends Comparable<T>> T max(T first, T second) {
        return (first.compareTo(second) > 0) ? first : second;
    }

    static <K, V> void printKV(K key, V value) {
        System.out.println(key + "=" + value);
    }
}