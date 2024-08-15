package dev.mayankg.multithreading.basic.example03;

/**
 * Different methods available for a thread (Thread class): <br>
 * 8. interrupt() <br>
 */
class Thread2 extends Thread {
    public Thread2(String name) {
        super(name);
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " started...");

        Thread2 t = new Thread2("test2");
        t.start();
        t.interrupt();  // Main interrupted t
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " finished sleeping for 2 sec");
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e);
        }
    }
}
