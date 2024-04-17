package dev.mayankg.dataStructures.linkedList;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListImplTest {
    private static LinkedListImpl<String> createALinkedListForTest() {
        LinkedListImpl<String> ll = new LinkedListImpl<>();
        ll.add("is");
        ll.add("a");
        ll.addFirst("This");
        ll.add("linked");
        ll.addLast("list");
        return ll;
    }

    @Test
    void testAddFirst() {
        LinkedListImpl<String> ll = createALinkedListForTest();
        assertEquals("This", ll.get(0));
    }

    @Test
    void testGetSize() {
        LinkedListImpl<String> ll = createALinkedListForTest();
        assertEquals(5, ll.getSize());
    }

    @Test
    void testAddLast() {
        LinkedListImpl<String> ll = createALinkedListForTest();
        assertEquals("list", ll.get(ll.getSize() - 1));
    }

    @Test
    void testRemoveFirst() {
        LinkedListImpl<String> ll = createALinkedListForTest();
        assertEquals("This", ll.get(0));
        ll.removeFirst();
        assertEquals("is", ll.get(0));
    }

    @Test
    void testRemoveLast() {
        LinkedListImpl<String> ll = createALinkedListForTest();
        assertEquals("list", ll.get(ll.getSize() - 1));
        ll.removeLast();
        assertEquals("linked", ll.get(ll.getSize() - 1));
    }

    @Test
    void testisEmpty() {
        LinkedListImpl<Integer> ll = new LinkedListImpl<>();
        assertTrue(ll.isEmpty());
        ll.add(1);
        assertFalse(ll.isEmpty());
    }

    @Test
    void testToString() {
        LinkedListImpl<String> ll = createALinkedListForTest();
        assertEquals("LL: [This -> is -> a -> linked -> list -> null]", ll.toString());
    }

    @Test
    void testGet() {
        LinkedListImpl<String> ll = createALinkedListForTest();
        assertEquals("is", ll.get(1));
        assertEquals("linked", ll.get(3));
        assertEquals("list", ll.get(4));
        assertThrows(IndexOutOfBoundsException.class, () -> ll.get(5));
    }

    @Test
    void testPeek() {
        LinkedListImpl<Integer> ll = new LinkedListImpl<>();
        assertNull(ll.peek());
        ll.add(1);
        assertNotNull(ll.peek());
        assertEquals(1, (int) ll.peek());
        ll.add(2);
        ll.add(3);
        assertEquals(3, (int) ll.peek());
    }

    @Test
    void testRemove() {
        LinkedListImpl<String> ll = createALinkedListForTest();

        // Remove an element in the middle of the list
        ll.remove(2);
        assertEquals("linked", ll.get(2));
        assertEquals(4, ll.getSize());

        // Remove the last element of the list
        ll.remove(ll.getSize() - 1);
        assertEquals("linked", ll.get(ll.getSize() - 1));
        assertEquals(3, ll.getSize());

        // Remove the first element of the list
        ll.remove(0);
        assertEquals("is", ll.get(0));
        assertEquals(2, ll.getSize());

        // Try to remove an element at an invalid index
        assertThrows(IndexOutOfBoundsException.class, () -> ll.remove(5));
    }

    @Test
    void testInsert() {
        LinkedListImpl<Integer> ll = new LinkedListImpl<>();

        // Insert at the beginning
        ll.insert(0, 1);
        assertEquals(1, ll.get(0).intValue());
        assertEquals(1, ll.getSize());

        // Insert in the middle
        ll.insert(1, 2);
        assertEquals(2, ll.get(1).intValue());
        assertEquals(2, ll.getSize());

        // Insert at the end
        ll.insert(2, 3);
        assertEquals(3, ll.get(2).intValue());
        assertEquals(3, ll.getSize());

        // Insert at an invalid index
        assertThrows(IndexOutOfBoundsException.class, () -> ll.insert(5, 4));
    }
}