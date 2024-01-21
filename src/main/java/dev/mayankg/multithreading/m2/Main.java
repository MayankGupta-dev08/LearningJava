package dev.mayankg.multithreading.m2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Thread.activeCount() " + Thread.activeCount());
        System.out.println("Runtime.getRuntime().availableProcessors() " + Runtime.getRuntime().availableProcessors());
    }
}