package dev.mayankg.ds_algo_patterns.dataStructures.linkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList<>();
    }

    @Test
    void testAddFirst() {
        list.addFirst(1);
        assertEquals(1, list.first());
        assertEquals(1, list.last());
        assertEquals(1, list.size());

        list.addFirst(2);
        assertEquals(2, list.first());
        assertEquals(1, list.last());
        assertEquals(2, list.size());
    }

    @Test
    void testAddLast() {
        list.addLast(1);
        assertEquals(1, list.first());
        assertEquals(1, list.last());
        assertEquals(1, list.size());

        list.addLast(2);
        assertEquals(1, list.first());
        assertEquals(2, list.last());
        assertEquals(2, list.size());
    }

    @Test
    void testRemoveFirst() {
        list.addLast(1);
        list.addLast(2);
        list.removeFirst();
        assertEquals(2, list.first());
        assertEquals(2, list.last());
        assertEquals(1, list.size());

        list.removeFirst();
        assertTrue(list.isEmpty());
    }

    @Test
    void testRemoveFirstEmptyList() {
        assertThrows(NoSuchElementException.class, () -> list.removeFirst());
    }

    @Test
    void testRemoveLast() {
        list.addLast(1);
        list.addLast(2);
        list.removeLast();
        assertEquals(1, list.first());
        assertEquals(1, list.last());
        assertEquals(1, list.size());

        list.removeLast();
        assertTrue(list.isEmpty());
    }

    @Test
    void testRemoveLastEmptyList() {
        assertThrows(NoSuchElementException.class, () -> list.removeLast());
    }

    @Test
    void testSizeAndIsEmpty() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        list.addLast(1);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    }

    @Test
    void testFirstAndLast() {
        assertNull(list.first());
        assertNull(list.last());

        list.addLast(1);
        assertEquals(1, list.first());
        assertEquals(1, list.last());

        list.addLast(2);
        assertEquals(1, list.first());
        assertEquals(2, list.last());
    }

    @Test
    void testGet() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    void testRemoveByIndex() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.remove(1);
        assertEquals(2, list.size());
        assertEquals(1, list.first());
        assertEquals(3, list.last());

        list.remove(0);
        assertEquals(1, list.size());
        assertEquals(3, list.first());
        assertEquals(3, list.last());

        list.remove(0);
        assertTrue(list.isEmpty());
    }

    @Test
    void testInsert() {
        list.addLast(1);
        list.addLast(3);

        list.insert(1, 2);
        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));

        list.insert(0, 0);
        assertEquals(4, list.size());
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
    }

    @Test
    void testClear() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void testIterator() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        int[] expected = {1, 2, 3};
        int i = 0;
        for (int value : list) {
            assertEquals(expected[i], value);
            i++;
        }
    }
}