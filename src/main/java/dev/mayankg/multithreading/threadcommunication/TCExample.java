package dev.mayankg.multithreading.threadcommunication;

/**
 * This class demonstrates the use of wait and notify methods to manage concurrent access to a shared resource. <br>
 * - **synchronized**: Ensures that only one thread can execute a block of code at a time. <br>
 * - **wait()**: Causes the current thread to wait until another thread invokes the notify() method or the notifyAll() method for this object. <br>
 * - **notify()**: Wakes up a single thread that is waiting on this object's monitor. <br>
 * - **notifyAll()**: Wakes up all threads that are waiting on this object's monitor. <br>
 */
public class TCExample {
    public static void main(String[] args) {
        var sharedResource = new SharedResource();
        var producer = new Thread(new Producer(sharedResource), "Producer");
        var consumer = new Thread(new Consumer(sharedResource), "Consumer");

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted: " + e.getLocalizedMessage());
        } finally {
            System.out.println("--------------------------------------");
            System.out.println("Main thread exiting");
        }
    }
}

/**
 * SharedResource class is a shared object among different threads.
 */
class SharedResource {
    private int data;
    private boolean hasData = false;

    public synchronized void produce(int data) {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.data = data;
        hasData = true;
        System.out.println(Thread.currentThread().getName() + " produced: " + data);
        notifyAll();
    }

    public synchronized int consume() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println(Thread.currentThread().getName() + " consumed: " + data);
        notifyAll();
        return data;
    }
}

/**
 * Producer class is a thread that produces data and notifies the consumer thread.
 */
class Producer implements Runnable {
    private final SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sharedResource.produce(i);
        }
    }
}

/**
 * Consumer class is a thread that consumes data produced by the producer thread.
 */
class Consumer implements Runnable {
    private final SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int data = sharedResource.consume();
        }
    }
}