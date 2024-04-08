package dev.mayankg.dataStructures.linkedList;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;

public class LLMostFAQTest {
    @Test
    public void reverseLinkedList_Collections() {
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 1; i <= 5; i++)
            ll.add(i);

        Collections.reverse(ll);
        Assert.assertEquals(5, (int) ll.getFirst());
        Assert.assertEquals(1, (int) ll.getLast());
    }

    @Test
    public void reverseLinkedList_iterative() {
        LinkedListImpl<Integer> ll = new LinkedListImpl<>();
        for (int i = 1; i <= 5; i++)
            ll.add(i);
        Integer i0 = ll.get(0);
        Integer i4 = ll.get(4);

        LLMostFAQ.reverseLL_iterative(ll);

        Assert.assertNotEquals(i0, ll.get(0));
        Assert.assertEquals(i0, ll.get(4));
        Assert.assertEquals(i4, ll.get(0));
    }

    @Test
    public void reverseLinkedList_recursive() {
        LinkedListImpl<Integer> ll = new LinkedListImpl<>();
        for (int i = 1; i <= 5; i++)
            ll.add(i);
        Integer i0 = ll.get(0);
        Integer i4 = ll.get(4);

        ll.head = LLMostFAQ.reverseLL_recursive(ll.head);

        Assert.assertNotEquals(i0, ll.get(0));
        Assert.assertEquals(i0, ll.get(4));
        Assert.assertEquals(i4, ll.get(0));
    }
}