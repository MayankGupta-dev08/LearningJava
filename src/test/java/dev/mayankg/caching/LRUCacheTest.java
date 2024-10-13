package dev.mayankg.caching;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    @BeforeEach
    void setUp() {
        // Initialize resources before each test
    }

    @AfterEach
    void tearDown() {
        // Clean up resources after each test
    }

    @Test
    void get() {
        LRUCache<Integer> cache = new LRUCache<>(2);
        cache.put("key1", 1);
        assertEquals(1, cache.get("key1"));
        assertNull(cache.get("key2"));
    }

    @Test
    void put() {
        LRUCache<Integer> cache = new LRUCache<>(2);
        cache.put("key1", 1);
        assertEquals(1, cache.get("key1"));
        cache.put("key1", 11);
        assertEquals(11, cache.get("key1"));

        cache.put("key2", 2);
        cache.put("key3", 3);
        assertNull(cache.get("key1"));
        assertEquals(2, cache.get("key2"));
        assertEquals(3, cache.get("key3"));
    }

    @Test
    void size() {
        LRUCache<Integer> cache = new LRUCache<>(2);
        assertEquals(0, cache.size());
        cache.put("key1", 1);
        assertEquals(1, cache.size());
        cache.put("key2", 2);
        assertEquals(2, cache.size());
        cache.put("key3", 3); // Exceeds capacity
        assertEquals(2, cache.size());
        cache.remove("key2");
        assertEquals(1, cache.size());
    }

    @Test
    void remove() {
        LRUCache<Integer> cache = new LRUCache<>(2);
        cache.put("key1", 1);

        cache.remove("key2");   // Removing non-existing key
        assertEquals(1, cache.get("key1"));

        cache.remove("key1");
        assertNull(cache.get("key1"));
        assertEquals(0, cache.size());
    }

    @Test
    void clear() {
        LRUCache<Integer> cache = new LRUCache<>(2);
        cache.put("key1", 1);
        cache.put("key2", 2);
        cache.clear();
        assertNull(cache.get("key1"));
        assertNull(cache.get("key2"));
    }
}