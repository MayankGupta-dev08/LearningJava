package dev.mayankg.dataStructures.queue;

class QueueTesting {
    public static void main(String[] args) {
        MyQueue queue = new QueueImplArr(5);
        MyQueue circularQueue = new CircularQueueImpl(5);
        testQueueImplementationUsingArray(circularQueue);
    }

    static void testQueueImplementationUsingArray(MyQueue queue) {
        // Enqueue some elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        // Display the queue
        queue.display(); // Queue: 10 20 30 40 50

        // Dequeue two elements
        System.out.println("Dequeued: " + queue.dequeue()); // Dequeued: 10
        System.out.println("Dequeued: " + queue.dequeue()); // Dequeued: 20

        // Display the updated queue
        queue.display(); // Queue: 30 40 50

        // Peek at the front element
        System.out.println("Front element: " + queue.peek()); // Front element: 30

        // Enqueue more elements
        queue.enqueue(60);
        queue.enqueue(70);

        // Display the updated queue
        queue.display(); // Queue: 30 40 50 60 70

        // Try to enqueue when the queue is full
        queue.enqueue(80); // Queue is full. Cannot enqueue 80

        // Dequeue all elements
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }

        // Try to dequeue when the queue is empty
        System.out.println("Dequeued: " + queue.dequeue()); // Queue is empty. Cannot dequeue.
    }
}