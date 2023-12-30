package dev.mayankg.multithreading;

class Thread2 implements Runnable {
    public Thread2() {}

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) System.out.printf("Inside %s %s%n", Thread.currentThread(), i);
    }
}