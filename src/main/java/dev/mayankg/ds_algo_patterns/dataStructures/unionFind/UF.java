package dev.mayankg.ds_algo_patterns.dataStructures.unionFind;

/**
 * Interface for Union Find data structure
 */
interface UF<E> {

    void union(E element1, E element2); // Connects two elements
    boolean isConnected(E element1, E element2);    // Checks if two elements are connected
    int find(E element);    // Finds the root/parent of the element

}
