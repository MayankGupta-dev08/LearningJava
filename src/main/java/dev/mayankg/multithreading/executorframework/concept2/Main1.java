package dev.mayankg.multithreading.executorframework.concept2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

class Main1 {

    /**
     * Output: <br>
     * Callable1 <br>
     * Callable2 <br>
     * 1 <br>
     * 2 <br>
     * Task was cancelled: null <br>
     * All tasks are done! <br>
     * <p>
     * Process finished with exit code 0
     */
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> callable1 = generateIntCallable(1);
        Callable<Integer> callable2 = generateIntCallable(2);
        Callable<Integer> callable3 = generateIntCallable(3);

        List<Callable<Integer>> callables = Arrays.asList(callable1, callable2, callable3);

        List<Future<Integer>> futures = null;
        try {
            futures = executor.invokeAll(callables, 1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }


        for (Future<Integer> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                System.out.println("Execution exception: " + e.getMessage());
            } catch (CancellationException e) {
                System.out.println("Task was cancelled: " + e.getMessage());
            }
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
        System.out.println("All tasks are done!");
    }

    private static Callable<Integer> generateIntCallable(int i) {
        return () -> {
            Thread.sleep(990);
            System.out.println("Callable" + i);
            return i;
        };
    }
}