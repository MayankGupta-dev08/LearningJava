package dev.mayankg.ds_algo_patterns.dataStructures.priorityqueue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaxPriorityQueueTest {

    @Test
    void testInsertAndMax() {
        MaxPriorityQueue<Integer> pq = new MaxPriorityQueue<>(10);
        pq.insert(5);
        pq.insert(10);
        pq.insert(3);
        pq.insert(8);

        assertEquals(10, pq.max());
    }

    @Test
    void testDelMax() {
        MaxPriorityQueue<Integer> pq = new MaxPriorityQueue<>(10);
        pq.insert(5);
        pq.insert(10);
        pq.insert(3);
        pq.insert(8);

        assertEquals(10, pq.delMax());
        assertEquals(8, pq.delMax());
        assertEquals(5, pq.delMax());
        assertEquals(3, pq.delMax());
        assertTrue(pq.isEmpty());
    }

    @Test
    void testIsEmpty() {
        MaxPriorityQueue<Integer> pq = new MaxPriorityQueue<>(10);
        assertTrue(pq.isEmpty());
        pq.insert(1);
        assertFalse(pq.isEmpty());
        pq.delMax();
        assertTrue(pq.isEmpty());
    }

    @Test
    void testSize() {
        MaxPriorityQueue<Integer> pq = new MaxPriorityQueue<>(10);
        assertEquals(0, pq.size());
        pq.insert(1);
        pq.insert(2);
        pq.insert(3);
        assertEquals(3, pq.size());
        pq.delMax();
        assertEquals(2, pq.size());
    }

    @Test
    void testResizing() {
        MaxPriorityQueue<Integer> pq = new MaxPriorityQueue<>(2);
        pq.insert(1);
        pq.insert(2);
        pq.insert(3);
        pq.insert(4);
        assertEquals(4, pq.size());
        assertEquals(4, pq.max());

        pq.delMax();
        pq.delMax();
        assertEquals(2, pq.size());
    }

    @Test
    void testMaxOnEmptyQueue() {
        MaxPriorityQueue<Integer> pq = new MaxPriorityQueue<>(10);
        Exception exception = assertThrows(IllegalStateException.class, pq::max);
        assertEquals("Priority queue underflow", exception.getMessage());
    }

    @Test
    void testDelMaxOnEmptyQueue() {
        MaxPriorityQueue<Integer> pq = new MaxPriorityQueue<>(10);
        Exception exception = assertThrows(IllegalStateException.class, pq::delMax);
        assertEquals("Priority queue underflow", exception.getMessage());
    }
}