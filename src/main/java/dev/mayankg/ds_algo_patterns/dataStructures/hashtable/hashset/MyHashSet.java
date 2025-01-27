package dev.mayankg.ds_algo_patterns.dataStructures.hashtable.hashset;

import java.util.*;

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
public class MyHashSet {
    private final double LOAD_FACTOR_THRESHOLD = 0.75;
    private int numOfBuckets;
    private LinkedList<Integer>[] buckets;
    private int size; // Number of elements in the hash set

    public MyHashSet() {
        numOfBuckets = 1000; // Initial number of buckets
        buckets = new LinkedList[numOfBuckets];
        for (int i = 0; i < numOfBuckets; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    // Hashing function to get the index of the bucket
    private int getHashValue(int key) {
        return key % numOfBuckets;
    }

    public void add(int key) {
        int idx = getHashValue(key);
        if (!buckets[idx].contains(key)) {
            buckets[idx].add(key);
            size++; // Increase size as a new element is added

            // Check load factor and rehash if necessary
            if ((double) size / numOfBuckets > LOAD_FACTOR_THRESHOLD) {
                rehash();
            }
        }
    }

    public void remove(int key) {
        int idx = getHashValue(key);
        if (buckets[idx].contains(key)) {
            buckets[idx].remove((Integer) key); //Explicitly cast key to Integer to remove by value
            size--; // Decrease size as an element is removed
        }
    }

    public boolean contains(int key) {
        int idx = getHashValue(key);
        return buckets[idx].contains(key);
    }

    /**
     * Rehash the hash set when the load factor exceeds the threshold
     */
    private void rehash() {
        // Double the number of buckets
        int newNumOfBuckets = numOfBuckets * 2;
        LinkedList<Integer>[] newBuckets = new LinkedList[newNumOfBuckets];
        for (int i = 0; i < newNumOfBuckets; i++) {
            newBuckets[i] = new LinkedList<>();
        }

        // Reinsert all elements into the new bucket array
        for (int i = 0; i < numOfBuckets; i++) {
            for (int key : buckets[i]) {
                int newIdx = key % newNumOfBuckets;
                newBuckets[newIdx].add(key);
            }
        }

        // Replace the old bucket array with the new one
        buckets = newBuckets;
        numOfBuckets = newNumOfBuckets;
    }
}