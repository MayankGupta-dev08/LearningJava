package dev.mayankg.multithreading.executorframework.example0;

public class WIthMT {

    /**
     * Calculates factorial of 10 numbers using 10 threads, utilizing multithreading
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Thread[] threads = new Thread[10];
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            threads[i - 1] = new Thread(
                    () -> System.out.println("Factorial of " + finalI + " is: " + MTUtil.factorial(finalI))
            );
            threads[i - 1].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }

        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("---------------------------------");
        System.out.println("Total time taken: " + endTime + " ms");
    }
}