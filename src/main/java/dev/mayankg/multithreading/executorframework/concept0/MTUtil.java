package dev.mayankg.multithreading.executorframework.concept0;

class MTUtil {
    /**
     * Factorial of a number using for loop
     */
    public static long factorial(int num) {
        int fact = 1;
        try {
            Thread.sleep(1000);
            for (int i = 1; i <= num; i++) {
                fact *= i;
            }
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
        return fact;
    }
}