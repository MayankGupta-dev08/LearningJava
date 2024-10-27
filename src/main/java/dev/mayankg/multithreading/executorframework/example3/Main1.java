package dev.mayankg.multithreading.executorframework.example3;

import java.util.concurrent.*;

class Main1 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(() -> {
            try {
                System.out.println("Task 1");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
            return 42;
        });

        try {
            System.out.println("Future is done: " + future.isDone());
            System.out.println("Future value: " + future.get(1, TimeUnit.SECONDS));
            System.out.println("Future is done: " + future.isDone());
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            System.out.println("TimeoutException occurred. " + e.getMessage());
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("All tasks are done!");
        }
    }
}
