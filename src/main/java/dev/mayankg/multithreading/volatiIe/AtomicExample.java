package dev.mayankg.multithreading.volatiIe;

import java.util.concurrent.atomic.AtomicInteger;

class VolatileCounter {
    private AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public int getCount() {
        return counter.get();
    }
}


/**
 * This example demonstrates the use of Atomic variables to perform thread-safe operations.
 */
class AtomicExample {
    public static void main(String[] args) {
        VolatileCounter counter = new VolatileCounter();

        Thread t1 = new Thread(
                () -> {
                    for (int i = 0; i < 100000; i++) {
                        counter.increment();
                    }
                },
                "Thread 1"
        );

        Thread t2 = new Thread(
                () -> {
                    for (int i = 0; i < 100000; i++) {
                        counter.increment();
                    }
                },
                "Thread 2"
        );

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
            Thread.currentThread().interrupt();
        }

        System.out.println("Final count: " + counter.getCount());
    }
}
