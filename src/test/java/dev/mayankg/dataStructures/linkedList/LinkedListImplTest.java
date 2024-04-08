package dev.mayankg.dataStructures.linkedList;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListImplTest {
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
    public void testAddFirst() {
        LinkedListImpl<String> ll = createALinkedListForTest();
        Assert.assertEquals("This", ll.get(0));
    }

    @Test
    public void testGetSize() {
        LinkedListImpl<String> ll = createALinkedListForTest();
        Assert.assertEquals(5, ll.getSize());
    }

    @Test
    public void testAddLast() {
        LinkedListImpl<String> ll = createALinkedListForTest();
        Assert.assertEquals("list", ll.get(ll.getSize() - 1));
    }

    @Test
    public void testRemoveFirst() {
        LinkedListImpl<String> ll = createALinkedListForTest();
        Assert.assertEquals("This", ll.get(0));
        ll.removeFirst();
        Assert.assertEquals("is", ll.get(0));
    }

    @Test
    public void testRemoveLast() {
        LinkedListImpl<String> ll = createALinkedListForTest();
        Assert.assertEquals("list", ll.get(ll.getSize() - 1));
        ll.removeLast();
        Assert.assertEquals("linked", ll.get(ll.getSize() - 1));
    }

    @Test
    public void testisEmpty() {
        LinkedListImpl<Integer> ll = new LinkedListImpl<>();
        Assert.assertTrue(ll.isEmpty());
        ll.add(1);
        Assert.assertFalse(ll.isEmpty());
    }

    @Test
    public void testToString() {
        LinkedListImpl<String> ll = createALinkedListForTest();
        Assert.assertEquals("LL: [This -> is -> a -> linked -> list -> null]", ll.toString());
    }

    @Test
    public void testGet() {
        LinkedListImpl<String> ll = createALinkedListForTest();
        Assert.assertEquals("is", ll.get(1));
        Assert.assertEquals("linked", ll.get(3));
        Assert.assertEquals("list", ll.get(4));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> ll.get(5));
    }

    @Test
    public void testPeek() {
        LinkedListImpl<Integer> ll = new LinkedListImpl<>();
        Assert.assertNull(ll.peek());
        ll.add(1);
        Assert.assertNotNull(ll.peek());
        Assert.assertEquals(1, (int) ll.peek());
        ll.add(2);
        ll.add(3);
        Assert.assertEquals(3, (int) ll.peek());
    }

    @Test
    public void testRemove() {
        LinkedListImpl<String> ll = createALinkedListForTest();

        // Remove an element in the middle of the list
        ll.remove(2);
        Assert.assertEquals("linked", ll.get(2));
        Assert.assertEquals(4, ll.getSize());

        // Remove the last element of the list
        ll.remove(ll.getSize() - 1);
        Assert.assertEquals("linked", ll.get(ll.getSize() - 1));
        Assert.assertEquals(3, ll.getSize());

        // Remove the first element of the list
        ll.remove(0);
        Assert.assertEquals("is", ll.get(0));
        Assert.assertEquals(2, ll.getSize());

        // Try to remove an element at an invalid index
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> ll.remove(5));
    }

    @Test
    public void testInsert() {
        LinkedListImpl<Integer> ll = new LinkedListImpl<>();

        // Insert at the beginning
        ll.insert(0, 1);
        Assert.assertEquals(1, ll.get(0).intValue());
        Assert.assertEquals(1, ll.getSize());

        // Insert in the middle
        ll.insert(1, 2);
        Assert.assertEquals(2, ll.get(1).intValue());
        Assert.assertEquals(2, ll.getSize());

        // Insert at the end
        ll.insert(2, 3);
        Assert.assertEquals(3, ll.get(2).intValue());
        Assert.assertEquals(3, ll.getSize());

        // Insert at an invalid index
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> ll.insert(5, 4));
    }
}