package dev.mayankg.multithreading.executorframework.concept5;

import java.util.concurrent.*;

/**
 * CountDownLatch is used to make the main thread wait until all tasks are completed.
 */
class Example1 {
    public static void main(String[] args) {
        final int numberOfTasks = 3;
        final CountDownLatch latch = new CountDownLatch(numberOfTasks);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfTasks);

        Future<String> future1 = executorService.submit(new DependentTask(latch));
        Future<String> future2 = executorService.submit(new DependentTask(latch));
        Future<String> future3 = executorService.submit(new DependentTask(latch));
        System.out.println("All tasks submitted for execution...");

        try {
            // we can use CountDownLatch to wait for all tasks to complete
            latch.await(); // instead of doing future.get() for each task,
            System.out.println("All tasks completed...");
        } catch (InterruptedException e) {
        }

        executorService.shutdown();
        System.out.println("Executor service shutdown initiated...");
        System.out.println("Main thread execution completed...");
    }
}

class DependentTask implements Callable<String> {
    private final CountDownLatch latch;

    public DependentTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + " task execution started...");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " task execution completed...");
        } finally {
            latch.countDown();
        }
        return "Dependent task result";
    }
}