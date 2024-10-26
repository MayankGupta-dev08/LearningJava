package dev.mayankg.multithreading.executorframework.example1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Main1 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        RunnableTask runnableTask = new RunnableTask();
        Future<?> future = executor.submit(runnableTask);

        try {
            if (future.isDone()) System.out.println("Task is done");
            System.out.println(future.get());
            if (future.isDone()) System.out.println("Task is done now!");
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            executor.shutdown();
        }

        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("---------------------------------");
        System.out.println("Total time taken: " + endTime + " ms");
    }
}
