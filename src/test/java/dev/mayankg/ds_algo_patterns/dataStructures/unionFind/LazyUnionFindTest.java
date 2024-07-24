package dev.mayankg.ds_algo_patterns.dataStructures.unionFind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LazyUnionFindTest {

    private LazyUnionFind unionFind;

    @BeforeEach
    void setUp() {
        unionFind = new LazyUnionFind(10);
    }

    @Test
    void testInitialSetup() {
        for (int i = 0; i < 10; i++) {
            assertEquals(i, unionFind.find(i), "Each element should initially be its own root.");
        }
    }

    @Test
    void testUnion() {
        unionFind.union(0, 1);
        assertEquals(unionFind.find(0), unionFind.find(1), "0 and 1 should be connected.");

        unionFind.union(1, 2);
        assertEquals(unionFind.find(0), unionFind.find(2), "0, 1, and 2 should be connected.");

        unionFind.union(3, 4);
        assertEquals(unionFind.find(3), unionFind.find(4), "3 and 4 should be connected.");

        unionFind.union(2, 4);
        assertEquals(unionFind.find(0), unionFind.find(4), "All elements (0, 1, 2, 3, 4) should be connected.");
    }

    @Test
    void testIsConnected() {
        assertFalse(unionFind.isConnected(0, 1), "Initially, 0 and 1 should not be connected.");

        unionFind.union(0, 1);
        assertTrue(unionFind.isConnected(0, 1), "0 and 1 should be connected after union.");

        unionFind.union(1, 2);
        assertTrue(unionFind.isConnected(0, 2), "0 and 2 should be connected after union.");

        unionFind.union(3, 4);
        assertFalse(unionFind.isConnected(0, 3), "0 and 3 should not be connected.");

        unionFind.union(2, 3);
        assertTrue(unionFind.isConnected(0, 4), "0 and 4 should be connected after union.");
    }

    @Test
    void testFind() {
        for (int i = 0; i < 10; i++) {
            assertEquals(i, unionFind.find(i), "Each element should initially be its own root.");
        }

        unionFind.union(0, 1);
        assertEquals(unionFind.find(0), unionFind.find(1), "0 and 1 should be connected.");

        unionFind.union(1, 2);
        assertEquals(unionFind.find(0), unionFind.find(2), "0, 1, and 2 should be connected.");

        unionFind.union(3, 4);
        assertEquals(unionFind.find(3), unionFind.find(4), "3 and 4 should be connected.");

        unionFind.union(2, 4);
        assertEquals(unionFind.find(0), unionFind.find(4), "All elements (0, 1, 2, 3, 4) should be connected.");
    }

    @Test
    void testUnionAlreadyConnected() {
        unionFind.union(0, 1);
        unionFind.union(1, 2);
        unionFind.union(2, 3);
        unionFind.union(3, 4);

        assertTrue(unionFind.isConnected(0, 4), "0 and 4 should be connected.");

        // Union two elements that are already connected
        unionFind.union(0, 4);

        // Ensure the structure is still valid and no unintended changes happened
        for (int i = 0; i <= 4; i++) {
            assertTrue(unionFind.isConnected(0, i), "All elements from 0 to 4 should still be connected.");
        }
    }

    @Test
    void testEdgeCases() {
        // Edge case: Union with itself
        unionFind.union(5, 5);
        assertTrue(unionFind.isConnected(5, 5), "An element should be connected to itself.");

        // Edge case: Find a non-existent element (should not be possible due to type safety)
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> unionFind.find(10), "Accessing out of bounds element should throw exception.");
    }
}