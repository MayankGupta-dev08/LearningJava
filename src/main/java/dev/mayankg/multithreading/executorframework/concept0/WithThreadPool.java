package dev.mayankg.multithreading.executorframework.concept0;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WithThreadPool {
    /**
     * Calculates factorial of 10 numbers using 3 threads via thread pool
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            executor.execute(
                    () -> System.out.println("Factorial of " + finalI + " is: " + MTUtil.factorial(finalI))
            );
        }
        executor.shutdown();
        try {
            while (!executor.awaitTermination(1, TimeUnit.MINUTES))
                System.out.println("Waiting for threads to finish...");
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("---------------------------------");
        System.out.println("Total time taken: " + endTime + " ms");
    }
}