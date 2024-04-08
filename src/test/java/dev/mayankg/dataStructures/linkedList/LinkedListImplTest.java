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
    public void addFirst() {
        LinkedListImpl<String> ll = createALinkedListForTest();
        Assert.assertEquals("This", ll.get(0));
    }

    @Test
    public void getSize() {
        LinkedListImpl<String> ll = createALinkedListForTest();
        Assert.assertEquals(5, ll.getSize());
    }

    @Test
    public void addLast() {
        LinkedListImpl<String> ll = createALinkedListForTest();
        Assert.assertEquals("list", ll.get(ll.getSize() - 1));
    }

    @Test
    public void removeFirst() {
        LinkedListImpl<String> ll = createALinkedListForTest();
        Assert.assertEquals("This", ll.get(0));
        ll.removeFirst();
        Assert.assertEquals("is", ll.get(0));
    }

    @Test
    public void removeLast() {
        LinkedListImpl<String> ll = createALinkedListForTest();
        Assert.assertEquals("list", ll.get(ll.getSize() - 1));
        ll.removeLast();
        Assert.assertEquals("linked", ll.get(ll.getSize() - 1));
    }

    @Test
    public void isEmpty() {
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
    public void get() {
        LinkedListImpl<String> ll = createALinkedListForTest();
        Assert.assertEquals("is", ll.get(1));
        Assert.assertEquals("linked", ll.get(3));
        Assert.assertEquals("list", ll.get(4));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
            ll.get(5);
        });
    }

    @Test
    public void peek() {
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
    public void remove() {
        LinkedListImpl<String> ll = createALinkedListForTest();
        ll.remove(-2);
    }
}