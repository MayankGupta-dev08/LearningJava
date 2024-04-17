package dev.mayankg.dataStructures.queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueImplTest {

    @AfterEach
    void printLineBreaker() {
        System.out.println("-------------------------------");
    }

    @Test
    void testQueueImplementationUsingArray() {
        MyQueue queueAr = new QueueImplArr(5);
        testQueue(queueAr);
    }

    @Test
    void testCircularQueueImplementation() {
        MyQueue circularQueue = new CircularQueueImpl(5);
        testQueue(circularQueue);
    }

    @Test
    void testLinkedQueueImplementation() {
        MyQueue queueLL = new QueueImplLnkL();
        testQueue(queueLL);
    }

    @Test
    void testQueueWithTwoStacksImplementation() {
        MyQueue queue2Stks = new QueueImpl2Stacks();
        testQueue(queue2Stks);
    }

    private void testQueue(MyQueue queue) {
        // Enqueue some elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        // Display the queue
        Assertions.assertEquals("Queue: [10, 20, 30, 40, 50]", queue.toString());
        Assertions.assertEquals(5, queue.size());

        // Dequeue two elements
        Assertions.assertEquals(10, queue.dequeue());
        Assertions.assertEquals(20, queue.dequeue());

        // Display the updated queue
        Assertions.assertEquals("Queue: [30, 40, 50]", queue.toString());
        Assertions.assertEquals(3, queue.size());

        // Peek at the front element
        Assertions.assertEquals(30, queue.peek());

        // Enqueue more elements
        queue.enqueue(60);
        queue.enqueue(70);

        // Display the updated queue
        Assertions.assertEquals("Queue: [30, 40, 50, 60, 70]", queue.toString());
        Assertions.assertEquals(5, queue.size());

        // Try to enqueue when the queue is full
        queue.enqueue(80); // The Queue is full. Cannot enqueue 80

        // Dequeue all elements
        StringBuilder dequeued = new StringBuilder();
        while (!queue.isEmpty()) {
            dequeued.append(queue.dequeue()).append(" ");
        }

        if (queue instanceof QueueImplArr || queue instanceof CircularQueueImpl)
            Assertions.assertEquals("30 40 50 60 70 ", dequeued.toString());
        else
            Assertions.assertEquals("30 40 50 60 70 80 ", dequeued.toString());

        // Try to dequeue when the queue is empty
        Assertions.assertEquals(-1, queue.dequeue()); // The Queue is empty. Cannot dequeue.
    }
}