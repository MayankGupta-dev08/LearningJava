package dev.mayankg.multithreading.basic.example04.synchronization;

class Test {

    /**
     * Without 'synchronization' both threads can access the increment method at the same time, leading to incrementing the value only once and not twice. <br>
     * With 'synchronization' only one thread can access that method at a time.
     */
    public static void main(String[] args) {
        Counter counter = new Counter();    // shared resource
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.err.println(e);
        }

        System.out.println(counter.getCount()); //20000
    }
}
