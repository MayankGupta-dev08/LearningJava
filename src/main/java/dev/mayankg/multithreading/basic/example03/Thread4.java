package dev.mayankg.multithreading.basic.example03;

/**
 * Different methods available for a thread (Thread class): <br>
 * 10. setDaemon() <br>
 */
class Thread4 extends Thread {
    public Thread4(String name) {
        super(name);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " is started");
        Thread4 t0 = new Thread4("t0");
        t0.setDaemon(true); // Converting t0 from 'user-thread' to a 'daemon-thread'.
        t0.start();
        System.out.println(Thread.currentThread().getName() + " is finished");
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Hola!");
        }
    }
}
