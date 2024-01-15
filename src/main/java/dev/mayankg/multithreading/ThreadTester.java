package dev.mayankg.multithreading;

class ThreadTester {

    public static void main(String[] args) {
        System.out.println("main is starting");

        // run/test all the below methods 1 by 1
        example_simple();
        example_synchronization();
        demoOnThreadStateExplanation();
        example_join();

        // will cause the program to run infinitely
        deadlockSituation();

        System.out.println("main is exiting");
    }

    private static void example_synchronization() {
        MyStack myStack = new MyStack(5);

        Thread pusher = new Thread(() -> {
            int counter = 0;
            while (++counter <= 10)
                System.out.println("Pushed: " + myStack.push(100));
        }, "Pusher");
        pusher.start();

        Thread popper = new Thread(() -> {
            int counter = 0;
            while (++counter <= 10)
                System.out.println("Popped: " + myStack.pop());
        }, "Popper");
        popper.start();
    }

    private static void example_simple() {
        Thread1 thread1 = new Thread1("thread1");
        // thread1.setDaemon(true);  // setting the thread to be a daemon thread instead of a normal user thread.
        // start() is an asynchronous function, so it returns immediately
        thread1.start();

        // This option is better, since the here we don't have to extend a class rather implement an interface which prevents the multiple inheritance scenario from happening
        Thread thread2 = new Thread(new Thread2(), "thread2");
        thread2.start();
    }

    private static void demoOnThreadStateExplanation() {
        Thread thread3 = new Thread(
                () -> {
                    try {
                        Thread.sleep(1);
                        for (int i = 10000; i > 0; i--) ;    //hot loop
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },
                "stateThread"
        );
        thread3.start();

        while (true) {
            Thread.State state = thread3.getState();
            System.out.println(state);
            if (state == Thread.State.TERMINATED) break;
        }
    }

    /**
     * join() method on a thread forces the completion of that particular thread and all its child thread
     * and blocks all other threads till those are completed.
     */
    private static void example_join() {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread());
        }, "Our thread");

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void deadlockSituation() {
        String lock1 = "myLock";
        String lock2 = "myOtherLock";

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock2) {
                    System.out.println("both the locks are acquired!");
                    System.out.println("work1 in progress...");
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock1) {
                    System.out.println("both the locks are acquired!");
                    System.out.println("work2 in progress...");
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}