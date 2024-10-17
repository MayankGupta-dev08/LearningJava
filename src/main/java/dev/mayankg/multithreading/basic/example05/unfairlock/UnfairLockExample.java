package dev.mayankg.multithreading.basic.example05.unfairlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;


/**
 * <ul>
 *     <li> The ReentrantLock class in Java provides an option to specify the fairness policy for lock acquisition.
 *     This policy determines the order in which threads acquire the lock. </li>
 *     <li> Fair lock: A fair lock ensures that the longest-waiting thread gets the lock next.
 *     This prevents thread starvation but can lead to lower throughput due to the overhead of maintaining the queue of waiting threads. </li>
 *     <li> Unfair lock: An unfair lock does not provide any ordering guarantees.
 *     It allows threads to "cut in line," which can lead to higher throughput but may cause thread starvation. </li>
 * </ul>
 */
class UnfairLockExample {
    private static final Logger logger = Logger.getLogger(UnfairLockExample.class.getName());
    private final Lock unfairLock = new ReentrantLock(false);    // false means it is unfair lock

    public static void main(String[] args) {
        var unfairLockExample = new UnfairLockExample();    // shared object among different threads
        Runnable runnable = unfairLockExample::accessResource;

        Thread t1 = new Thread(runnable, "Thread-1");
        Thread t2 = new Thread(runnable, "Thread-2");
        Thread t3 = new Thread(runnable, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }

    public void accessResource() {
        try {
            unfairLock.lock();
            System.out.println(Thread.currentThread().getName() + " has acquired the lock");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " accessing the resource");
        } catch (InterruptedException e) {
            logger.severe(e.getLocalizedMessage());
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " has released the lock");
            unfairLock.unlock();
        }
    }
}
