package dev.mayankg.ds_algo_patterns.dataStructures.dynamicArray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

    private DynamicArray<Integer> array;

    @BeforeEach
    void setUp() {
        array = new DynamicArray<>();
    }

    @Test
    void testDefaultConstructor() {
        assertEquals(0, array.size());
        assertTrue(array.isEmpty());
    }

    @Test
    void testConstructorWithCapacity() {
        DynamicArray<Integer> arrayWithCapacity = new DynamicArray<>(20);
        assertEquals(0, arrayWithCapacity.size());
        assertTrue(arrayWithCapacity.isEmpty());
    }

    @Test
    void testAdd() {
        array.add(1);
        array.add(2);
        array.add(3);

        assertEquals(3, array.size());
        assertEquals(1, array.get(0));
        assertEquals(2, array.get(1));
        assertEquals(3, array.get(2));
    }

    @Test
    void testAddWithResize() {
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }
        assertEquals(10, array.size());
        for (int i = 0; i < 10; i++) {
            assertEquals(i, array.get(i));
        }
    }

    @Test
    void testClear() {
        array.add(1);
        array.add(2);
        array.add(3);

        array.clear();
        assertEquals(0, array.size());
        assertTrue(array.isEmpty());
    }

    @Test
    void testRemoveAt() {
        array.add(1);
        array.add(2);
        array.add(3);
        assertEquals(3, array.size());

        assertEquals(2, array.removeAt(1));
        assertEquals(2, array.size());

        assertEquals(1, array.get(0));
        assertEquals(3, array.get(1));
    }

    @Test
    void testRemoveAtInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> array.removeAt(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> array.removeAt(1));
    }

    @Test
    void testGetAndSet() {
        array.add(1);
        array.add(2);
        array.set(1, 3);

        assertEquals(1, array.get(0));
        assertEquals(3, array.get(1));
    }

    @Test
    void testContains() {
        array.add(1);
        array.add(2);
        array.add(3);
        assertTrue(array.contains(2));
        assertFalse(array.contains(4));
    }

    @Test
    void testIndexOf() {
        array.add(1);
        array.add(2);
        array.add(3);
        assertEquals(1, array.indexOf(2));
        assertEquals(-1, array.indexOf(4));
    }

    @Test
    void testToString() {
        array.add(1);
        array.add(2);
        array.add(3);
        assertEquals("[1, 2, 3]", array.toString());
    }

    @Test
    void testIterator() {
        array.add(1);
        array.add(2);
        array.add(3);
        Iterator<Integer> iterator = array.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());
    }
}
