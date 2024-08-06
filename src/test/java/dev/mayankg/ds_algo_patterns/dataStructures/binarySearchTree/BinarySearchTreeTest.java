package dev.mayankg.ds_algo_patterns.dataStructures.binarySearchTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private BinarySearchTree<Integer, String> bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
        bst.put(5, "Five");
        bst.put(3, "Three");
        bst.put(7, "Seven");
        bst.put(2, "Two");
        bst.put(4, "Four");
        bst.put(6, "Six");
        bst.put(8, "Eight");
    }

    @Test
    void testGet() {
        assertEquals("Five", bst.get(5));
        assertEquals("Three", bst.get(3));
        assertEquals("Seven", bst.get(7));
        assertNull(bst.get(10));
    }

    @Test
    void testSize() {
        assertEquals(7, bst.size());
    }

    @Test
    void testPut() {
        bst.put(1, "One");
        assertEquals(8, bst.size());
        assertEquals("One", bst.get(1));

        bst.put(5, "Five Updated");
        assertEquals(8, bst.size());
        assertEquals("Five Updated", bst.get(5));
    }

    @Test
    void testMin() {
        assertEquals(2, bst.min());
    }

    @Test
    void testMax() {
        assertEquals(8, bst.max());
    }

    @Test
    void testDelete() {
        bst.delete(3);
        assertEquals(6, bst.size());
        assertNull(bst.get(3));

        bst.delete(5);
        assertEquals(5, bst.size());
        assertNull(bst.get(5));
    }

    @Test
    void testFloor() {
        assertEquals(4, bst.floor(4));
        assertEquals(4, bst.floor(5));
        assertEquals(8, bst.floor(9));
        assertNull(bst.floor(1));
    }

    @Test
    void testCeil() {
        assertEquals(4, bst.ceil(3));
        assertEquals(6, bst.ceil(6));
        assertEquals(7, bst.ceil(7));
        assertNull(bst.ceil(9));
    }

    @Test
    void testRank() {
        assertEquals(0, bst.rank(2));
        assertEquals(1, bst.rank(3));
        assertEquals(4, bst.rank(6));
        assertEquals(7, bst.rank(8));
    }

    @Test
    void testIterator() {
        Iterator<Integer> iterator = bst.iterator();
        int[] expectedOrder = {2, 3, 4, 5, 6, 7, 8};
        int index = 0;
        while (iterator.hasNext()) {
            assertEquals(expectedOrder[index++], iterator.next());
        }
    }

    @Test
    void testKeys() {
        Iterable<Integer> keys = bst.keys();
        int[] expectedOrder = {2, 3, 4, 5, 6, 7, 8};
        int index = 0;
        for (int key : keys) {
            assertEquals(expectedOrder[index++], key);
        }
    }
}