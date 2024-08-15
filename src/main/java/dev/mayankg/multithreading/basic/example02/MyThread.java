package dev.mayankg.multithreading.basic.example02;

public class MyThread extends Thread {

    /**
     * Inside this method, work is done by the main thread.
     */
    public static void main(String[] args) {
        MyThread t0 = new MyThread();
        System.out.println(t0.getState());

        t0.start();
        System.out.println(t0.getState());

        try {   // sending the main thread to sleep for 3 sec
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.err.println(e);
        }

        System.out.println(t0.getState());

        try {
            t0.join();  // 'main' thread will wait for the 't0' thread to finish its work and join with it.
        } catch (InterruptedException e) {
            System.err.println(e);
        }

        System.out.println(t0.getState());
    }

    @Override
    public void run() {
        System.out.println("RUNNING");

        try {   // sending this thread to sleep for 5 sec
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
