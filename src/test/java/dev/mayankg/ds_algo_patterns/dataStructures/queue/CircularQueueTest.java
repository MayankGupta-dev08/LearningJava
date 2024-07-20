package dev.mayankg.ds_algo_patterns.dataStructures.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularQueueTest {

    private CircularQueue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new CircularQueue<>(5);  // Capacity set to 5 for testing
    }

    @Test
    void testEnqueue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size());
        assertEquals(1, queue.peek());
    }

    @Test
    void testDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testDequeueEmptyQueue() {
        assertThrows(IllegalStateException.class, () -> queue.dequeue());
    }

    @Test
    void testPeek() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.peek());
    }

    @Test
    void testPeekEmptyQueue() {
        assertThrows(IllegalStateException.class, () -> queue.peek());
    }

    @Test
    void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }

    @Test
    void testIsFull() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        assertTrue(queue.isFull());
    }

    @Test
    void testSize() {
        assertEquals(0, queue.size());
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());
        queue.dequeue();
        assertEquals(1, queue.size());
    }

    @Test
    void testClear() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.clear();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    void testToString() {
        assertEquals("Queue is empty.", queue.toString());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals("Queue: [1, 2, 3]", queue.toString());
    }

    @Test
    void testEnqueueToFullCapacity() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        assertThrows(IllegalStateException.class, () -> queue.enqueue(6));
    }

    @Test
    void testCircularity() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.enqueue(6);
        assertEquals("Queue: [2, 3, 4, 5, 6]", queue.toString());
    }

    @Test
    void testEdgeCaseCapacityZero() {
        assertThrows(IllegalArgumentException.class, () -> new CircularQueue<>(0));
    }
}