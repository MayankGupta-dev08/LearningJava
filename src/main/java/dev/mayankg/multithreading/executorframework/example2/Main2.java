package dev.mayankg.multithreading.executorframework.example2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

class Main2 {

    /**
     * Output: (will be random) <br>
     * Callable2 <br>
     * Callable3 <br>
     * Callable1 <br>
     * 2 <br>
     * All tasks are done! <br>
     * <p>
     * Process finished with exit code 0
     */
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<Integer> callable1 = generateIntCallable(1);
        Callable<Integer> callable2 = generateIntCallable(2);
        Callable<Integer> callable3 = generateIntCallable(3);

        List<Callable<Integer>> callables = Arrays.asList(callable1, callable2, callable3);

        try {
            Integer i = executor.invokeAny(callables, 1, TimeUnit.SECONDS);
            System.out.println(i);
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        } catch (TimeoutException e) {
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
            Thread.sleep(900);
            System.out.println("Callable" + i);
            return i;
        };
    }
}