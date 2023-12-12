package dev.mayankg.multithreading;

public class ThreadTester {

    public static void main(String[] args) {
        System.out.println("main is starting");

        Thread1 thread1 = new Thread1("thread1");
        // thread1.setDaemon(true);  // setting the thread to be a daemon thread instead of a normal user thread.
        // start() is an asynchronous function, so it returns immediately
        thread1.start();

        // This option is better, since the here we don't have to extend a class rather implement an interface which prevents the multiple inheritance scenario from happening
        Thread thread2 = new Thread(new Thread2(), "thread2");
        thread2.start();

        System.out.println("main is exiting");
    }

}