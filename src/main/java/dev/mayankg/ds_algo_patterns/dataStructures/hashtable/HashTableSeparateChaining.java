package dev.mayankg.ds_algo_patterns.dataStructures.hashtable;

import java.util.*;

/**
 * HashTable with Separate Chaining
 */
@SuppressWarnings("unchecked")
public class HashTableSeparateChaining<K, V> implements HashTableI<K, V>, Iterable<K> {
    private static final int DEFAULT_CAPACITY = 3;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private double maxLoadFactor;
    private int capacity, threshold, size = 0;
    private LinkedList<Entry<K, V>>[] table;

    public HashTableSeparateChaining() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashTableSeparateChaining(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public HashTableSeparateChaining(int capacity, double maxLoadFactor) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal capacity");
        if (maxLoadFactor <= 0 || Double.isNaN(maxLoadFactor) || Double.isInfinite(maxLoadFactor))
            throw new IllegalArgumentException("Illegal maxLoadFactor");

        this.capacity = Math.max(DEFAULT_CAPACITY, capacity);
        this.maxLoadFactor = maxLoadFactor;
        this.threshold = (int) (this.capacity * this.maxLoadFactor);
        table = new LinkedList[this.capacity];  // Array of LinkedList with lazy initialization
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        int index = normalizeIndex(key.hashCode());
        return bucketSeekEntry(index, key) != null;
    }

    @Override
    public V put(K key, V value) {
        return insert(key, value);
    }

    @Override
    public V add(K key, V value) {
        return insert(key, value);
    }

    @Override
    public V insert(K key, V value) {
        if (key == null) throw new IllegalArgumentException("Null key");
        Entry<K, V> newEntry = new Entry<>(key, value);
        int bucketIndex = normalizeIndex(newEntry.hash);
        return bucketInsertEntry(bucketIndex, newEntry);
    }

    @Override
    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("Null key");
        int bucketIndex = normalizeIndex(key.hashCode());
        Entry<K, V> entry = bucketSeekEntry(bucketIndex, key);
        return entry != null ? entry.value : null;
    }

    @Override
    public V remove(K key) {
        if (key == null) throw new IllegalArgumentException("Null key");
        int bucketIndex = normalizeIndex(key.hashCode());
        return bucketRemoveEntry(bucketIndex, key);
    }

    /**
     * Converts a hash value to an index. Essentially, this strips the
     * negative sign and places the hash value in the domain [0, capacity)
     */
    private int normalizeIndex(int keyHash) {
        return (keyHash & 0x7FFFFFFF) % capacity;
    }

    // Removes an entry from a given bucket if it exists
    private V bucketRemoveEntry(int bucketIndex, K key) {
        Entry<K, V> entry = bucketSeekEntry(bucketIndex, key);
        if (entry != null) {
            LinkedList<Entry<K, V>> bucket = table[bucketIndex];
            bucket.remove(entry);
            size--;
            return entry.value;
        }
        return null;
    }

    // Inserts an entry in a given bucket only if the entry does not already
    // exist in the given bucket, but if it does then update the entry value
    private V bucketInsertEntry(int bucketIndex, Entry<K, V> entry) {
        // check if the bucket exits for the given index, since we are using lazy initialization
        LinkedList<Entry<K, V>> bucket = table[bucketIndex];
        if (bucket == null) table[bucketIndex] = bucket = new LinkedList<>();

        // now bucket is guaranteed to exist, so check if the entry already exists in the bucket
        Entry<K, V> existentEntry = bucketSeekEntry(bucketIndex, entry.key);
        if (existentEntry == null) {
            bucket.add(entry);
            if (++size > threshold) resizeTable();
            return null; // No previous entry
        }
        // Entry already exists in the bucket, update the value
        V oldValue = existentEntry.value;
        existentEntry.value = entry.value;
        return oldValue;
    }

    // Finds and returns a particular entry in a given bucket if it exists, returns null otherwise
    private Entry<K, V> bucketSeekEntry(int bucketIndex, K key) {
        if (key == null) return null;

        LinkedList<Entry<K, V>> bucket = table[bucketIndex];
        if (bucket == null) return null;

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) return entry;
        }
        return null;
    }

    // Resizes the internal table holding buckets of entries
    private void resizeTable() {
        this.capacity *= 2;
        this.threshold = (int) (this.capacity * this.maxLoadFactor);

        LinkedList<Entry<K, V>>[] newTable = new LinkedList[this.capacity];
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i] != null) {
                for (Entry<K, V> entry : table[i]) {
                    int newIdx = normalizeIndex(entry.hash);
                    LinkedList<Entry<K, V>> bucket = newTable[newIdx];
                    if (bucket == null) newTable[newIdx] = bucket = new LinkedList<>();
                    bucket.add(entry);
                }
                // Avoid memory leak. Help the GC
                table[i].clear();
                table[i] = null;
            }
        }
        table = newTable;
    }

    @Override
    public List<K> keys() {
        List<K> keys = new ArrayList<>(size);
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                for (Entry<K, V> entry : table[i])
                    keys.add(entry.key);
            }
        }
        return keys;
    }

    @Override
    public List<V> values() {
        List<V> values = new ArrayList<>(size);
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                for (Entry<K, V> entry : table[i])
                    values.add(entry.value);
            }
        }
        return values;
    }

    // Return an iterator to iterate over all the keys in this map
    @Override
    public Iterator<K> iterator() {
        final int elementCount = size();

        return new Iterator<K>() {
            int bucketIndex = 0;
            Iterator<Entry<K, V>> bucketIterator = (table[0] == null) ? null : table[0].iterator();

            @Override
            public boolean hasNext() {
                // ensures that the map hasn't been modified since the creation of the iterator
                if (elementCount != size()) throw new ConcurrentModificationException();

                // If No iterator or the current iterator is empty
                while (bucketIterator == null || !bucketIterator.hasNext() && bucketIndex < capacity - 1) {
                    // Search next buckets until a valid iterator is found on non-empty bucket
                    bucketIndex++;
                    if (table[bucketIndex] != null) {
                        // Found a non-empty bucket, assign its iterator to bucketIterator
                        bucketIterator = table[bucketIndex].iterator();
                    }
                }
                return bucketIterator != null && bucketIterator.hasNext();
            }

            @Override
            public K next() {
                if (bucketIterator == null || !bucketIterator.hasNext()) {
                    throw new NoSuchElementException();
                }
                return bucketIterator.next().key;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

/**
 * Entry class for HashTable
 */
class Entry<K, V> {
    K key;
    V value;
    int hash;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.hash = key.hashCode();
    }

    public boolean equals(Entry<K, V> other) {
        if (this.hash != other.hash) return false;
        return this.key.equals(other.key);
    }

    @Override
    public String toString() {
        return key + " => " + value;
    }
}