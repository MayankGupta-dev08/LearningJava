package dev.mayankg.multithreading.executorframework.concept3;

import java.util.concurrent.*;

class Main2 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(() -> {
            try {
                System.out.println("Task 1: Sleeping for 2 seconds");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
            return 42;
        });

        /*try {
            System.out.println("Waiting for 1 second");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }*/

        try {
            System.out.println("Is future done: " + future.isDone());
            System.out.println("Cancelling the future");
            future.cancel(true);
            System.out.println("Is future cancelled: " + future.isCancelled());
            System.out.println("Is future done: " + future.isDone());
            System.out.println("Future value: " + future.get());
        } catch (InterruptedException | ExecutionException | CancellationException e) {
            System.out.println("CancellationException occurred.");
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, java.util.concurrent.TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        } finally {
            System.out.println("All tasks are done!");
        }
    }
}