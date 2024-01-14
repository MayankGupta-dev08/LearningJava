package dev.mayankg.multithreading;

class ThreadTester {

    public static void main(String[] args) {
        System.out.println("main is starting");

//        example_simple();
//        example_synchronization();
        demoOnThreadStateExplanation();

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

}