package dev.mayankg.multithreading.executorframework.concept5;

import java.util.concurrent.*;

/**
 * CountDownLatch is used to make the main thread wait until all tasks are completed.
 */
class Example2 {
    public static void main(String[] args) {
        final int numberOfTasks = 3;
        final CountDownLatch latch = new CountDownLatch(numberOfTasks);
        for (int i = 0; i < numberOfTasks; i++) {
            Thread t = new Thread(new DependentService(latch));
            t.setDaemon(true); t.start();
        }
        System.out.println("All tasks submitted for execution...");

        try {
            // we can use CountDownLatch to wait for all tasks to complete
            latch.await(5, TimeUnit.SECONDS); // instead of doing future.get() for each task,
            System.out.println("Task execution time limit over...");
        } catch (InterruptedException e) {
        }

        System.out.println("Main thread execution completed...");
    }
}

class DependentService implements Runnable {
    private final CountDownLatch latch;

    public DependentService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " task execution started...");
            Thread.sleep(6000);
            System.out.println(Thread.currentThread().getName() + " task execution completed...");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " task execution interrupted...");
        } finally {
            latch.countDown();
        }
    }
}