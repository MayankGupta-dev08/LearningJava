package dev.mayankg.multithreading.basic.example03;

/**
 * Different methods available for a thread (Thread class): <br>
 * 1. start() <br>
 * 2. run() <br>
 * 3. sleep() <br>
 * 4. join() <br>
 * 5. getState() <br>
 * 6. constructor(name) & getName() <br>
 * 7. setPriority() & getPriority() - You could only suggest the jvm by setting the priority, but jvm will schedule with his own choice. <br>
 */
class Thread1 extends Thread {
    public Thread1(String name) {
        super(name);
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getState() + "\n");

        var t1 = new Thread1("low-priority-thread");
        t1.setPriority(Thread.MIN_PRIORITY);

        var t2 = new Thread1("normal-priority-thread");
        t2.setPriority(Thread.NORM_PRIORITY);

        var t3 = new Thread1("high-priority-thread");
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();  //Main stops and waits for t1
            t2.join();  //Main stops and waits for t2
            t3.join();  //Main stops and waits for t3
        } catch (InterruptedException e) {
            System.err.println(e);
        }

        System.out.println("\nDone!!");
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            var a = "";
            for (int j = 0; j < 100000; j++) {
                a += j;
            }
            System.out.println(Thread.currentThread().getName() + " - Priority=" + Thread.currentThread().getPriority() + " - count=" + i);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}
