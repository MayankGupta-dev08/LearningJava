package dev.mayankg.ds_algo_patterns.dataStructures.hashmap;

import java.util.LinkedList;
import java.util.List;

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
public class MyHashMap {
    private final double LOAD_FACTOR_THRESHOLD = 0.75;
    private int size;
    private int numOfBuckets;
    private List<Pair>[] buckets;

    public MyHashMap() {
        this.numOfBuckets = 10000;
        buckets = new LinkedList[numOfBuckets];
        for (int i = 0; i < numOfBuckets; i++) {
            buckets[i] = new LinkedList<>(); // Initialize each bucket separately
        }
    }

    public void put(int key, int value) {
        int i = getHashValue(key);
        for (Pair pair : buckets[i]) {
            if (pair.key == key) {
                pair.val = value; // if present update
                return;
            }
        }
        buckets[i].add(new Pair(key, value)); // if not present add
        size++;

        if ((double) size / numOfBuckets > LOAD_FACTOR_THRESHOLD) {
            rehash();
        }
    }

    public int get(int key) {
        int i = getHashValue(key);
        for (Pair pair : buckets[i]) {
            if (pair.key == key)
                return pair.val;
        }
        return -1;
    }

    public void remove(int key) {
        int i = getHashValue(key);
        for (Pair pair : buckets[i]) {
            if (pair.key == key) {
                buckets[i].remove(pair);
                size--;
                return;
            }
        }
    }

    private int getHashValue(int key) {
        return key % numOfBuckets;
    }

    private void rehash() {
        List<Pair>[] oldBuckets = buckets;
        numOfBuckets *= 2;

        buckets = new LinkedList[numOfBuckets];
        for (int i = 0; i < numOfBuckets; i++) {
            buckets[i] = new LinkedList<>();
        }   // Initialize each bucket separately

        for (List<Pair> bucket : oldBuckets) {
            for (Pair pair : bucket) {
                put(pair.key, pair.val);    // Reinsert all elements into the new bucket array using put method
            }
        }
    }

    static class Pair {
        int key;
        int val;

        Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}