package dev.mayankg.multithreading;

class Thread1 extends Thread {
    public Thread1(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) System.out.printf("Inside %s %s%n", Thread.currentThread(), i);
    }
}