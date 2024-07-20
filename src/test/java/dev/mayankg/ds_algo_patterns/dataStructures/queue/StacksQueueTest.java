package dev.mayankg.ds_algo_patterns.dataStructures.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StacksQueueTest {

    private StacksQueue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new StacksQueue<>();
    }

    @Test
    void testEnqueueAndDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(3, queue.size());
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
        queue.enqueue(3);
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
    void testSize() {
        assertEquals(0, queue.size());
        queue.enqueue(1);
        assertEquals(1, queue.size());
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
        assertEquals("Queue is empty!", queue.toString());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals("[1, 2, 3]", queue.toString());
    }

    @Test
    void testIsFull() {
        assertFalse(queue.isFull());
    }
}