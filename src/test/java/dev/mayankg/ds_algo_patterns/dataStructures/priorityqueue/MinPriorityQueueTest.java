package dev.mayankg.ds_algo_patterns.dataStructures.priorityqueue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MinPriorityQueueTest {

    @Test
    void testInsertAndMin() {
        MinPriorityQueue<Integer> pq = new MinPriorityQueue<>(10);
        pq.insert(10);
        pq.insert(5);
        pq.insert(3);
        pq.insert(8);

        assertEquals(3, pq.min());
    }

    @Test
    void testDelMin() {
        MinPriorityQueue<Integer> pq = new MinPriorityQueue<>(10);
        pq.insert(10);
        pq.insert(5);
        pq.insert(3);
        pq.insert(8);

        assertEquals(3, pq.delMin());
        assertEquals(5, pq.delMin());
        assertEquals(8, pq.delMin());
        assertEquals(10, pq.delMin());
        assertTrue(pq.isEmpty());
    }

    @Test
    void testIsEmpty() {
        MinPriorityQueue<Integer> pq = new MinPriorityQueue<>(10);
        assertTrue(pq.isEmpty());
        pq.insert(1);
        assertFalse(pq.isEmpty());
        pq.delMin();
        assertTrue(pq.isEmpty());
    }

    @Test
    void testSize() {
        MinPriorityQueue<Integer> pq = new MinPriorityQueue<>(10);
        assertEquals(0, pq.size());
        pq.insert(1);
        pq.insert(2);
        pq.insert(3);
        assertEquals(3, pq.size());
        pq.delMin();
        assertEquals(2, pq.size());
    }

    @Test
    void testResizing() {
        MinPriorityQueue<Integer> pq = new MinPriorityQueue<>(2);
        pq.insert(4);
        pq.insert(3);
        pq.insert(2);
        pq.insert(1);
        assertEquals(4, pq.size());
        assertEquals(1, pq.min());

        pq.delMin();
        pq.delMin();
        assertEquals(2, pq.size());
    }

    @Test
    void testMinOnEmptyQueue() {
        MinPriorityQueue<Integer> pq = new MinPriorityQueue<>(10);
        Exception exception = assertThrows(IllegalStateException.class, pq::min);
        assertEquals("Priority queue underflow", exception.getMessage());
    }

    @Test
    void testDelMinOnEmptyQueue() {
        MinPriorityQueue<Integer> pq = new MinPriorityQueue<>(10);
        Exception exception = assertThrows(IllegalStateException.class, pq::delMin);
        assertEquals("Priority queue underflow", exception.getMessage());
    }
}