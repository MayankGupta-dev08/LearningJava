package dev.mayankg.ds_algo_patterns.dataStructures.linkedList;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;

class LLMostFAQTest {
    @AfterEach
    void printLineBreaker() {
        System.out.println("-------------------------------");
    }

    @Test
    void reverseLinkedList_Collections() {
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 1; i <= 5; i++)
            ll.add(i);

        Collections.reverse(ll);
        Assertions.assertEquals(5, (int) ll.getFirst());
        Assertions.assertEquals(1, (int) ll.getLast());
    }

    @Test
    void reverseLinkedList_iterative() {
        LinkedListImpl<Integer> ll = new LinkedListImpl<>();
        for (int i = 1; i <= 5; i++)
            ll.add(i);
        Integer i0 = ll.get(0);
        Integer i4 = ll.get(4);

        LLMostFAQ.reverseLL_iterative(ll);

        Assertions.assertNotEquals(i0, ll.get(0));
        Assertions.assertEquals(i0, ll.get(4));
        Assertions.assertEquals(i4, ll.get(0));
    }

    @Test
    void reverseLinkedList_recursive() {
        LinkedListImpl<Integer> ll = new LinkedListImpl<>();
        for (int i = 1; i <= 5; i++)
            ll.add(i);
        Integer i0 = ll.get(0);
        Integer i4 = ll.get(4);

        ll.head = LLMostFAQ.reverseLL_recursive(ll.head);

        Assertions.assertNotEquals(i0, ll.get(0));
        Assertions.assertEquals(i0, ll.get(4));
        Assertions.assertEquals(i4, ll.get(0));
    }
}