package dev.mayankg.multithreading.basic.example03;

/**
 * Different methods available for a thread (Thread class): <br>
 * 9. yield() <br>
 */
class Thread3 extends Thread {
    public Thread3(String name) {
        super(name);
    }

    public static void main(String[] args) {
        Thread3 t1 = new Thread3("t1");
        Thread3 t2 = new Thread3("t2");

        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running");
            Thread.yield(); // A hint to the scheduler that the current thread is willing to yield its current use of a processor. The scheduler is free to ignore this hint.
        }
    }
}
