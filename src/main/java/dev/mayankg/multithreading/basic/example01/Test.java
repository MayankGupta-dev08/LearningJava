package dev.mayankg.multithreading.basic.example01;

/**
 * Multi-threading basic example, three threads running in parallel
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "starts...");

        Thread t1 = new Other();    // t1 in NEW state
        t1.start(); // t1 in RUNNABLE state

        Thread t2 = new Thread(new Another());  // t2 in NEW state
        t2.start(); // t1 in RUNNABLE state

        for (int i = 0; i < 100000; i++) {
            System.out.println(Thread.currentThread().getName());
        }

        System.out.println(Thread.currentThread().getName() + "ends...");
    }
}