package dev.mayankg.multithreading.executorframework.concept0;

public class WithoutMT {

    /**
     * Iterates over 10 numbers and calculates factorial of each number
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 10; i++) {
            System.out.println("Factorial of " + i + " is: " + MTUtil.factorial(i));
        }
        System.out.println("---------------------------------");
        System.out.println("Total time taken: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}