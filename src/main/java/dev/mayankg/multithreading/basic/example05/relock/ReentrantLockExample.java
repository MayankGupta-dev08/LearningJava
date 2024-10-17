package dev.mayankg.multithreading.basic.example05.relock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;


/**
 * A ReentrantLock is owned by the thread last successfully locking, but not yet unlocking it.
 * A thread invoking lock will return, successfully acquiring the lock, when the lock is not owned by another thread.
 * The method will return immediately if the current thread already owns the lock.
 * This can be checked using methods isHeldByCurrentThread, and getHoldCount.
 */
class ReentrantLockExample {
    private static final Logger logger = Logger.getLogger(ReentrantLockExample.class.getName());
    private final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        var reentrantLockExample = new ReentrantLockExample();
        reentrantLockExample.outerMethod();
    }

    /**
     * lock.lockInterruptibly() is used to acquire the lock, but it can be interrupted by another thread.
     */
    void outerMethod() {
        try {
            lock.lockInterruptibly();    //the main thread acquires lock for the 1st time
            System.out.println("Inside the outer method");
            innerMethod();
        } catch (InterruptedException e) {
            logger.severe(e.getLocalizedMessage());
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();  //the main thread releases the lock which it had acquired for the 1st time
        }
    }

    /**
     * If it was not a reentrant lock, then this scenario would be considered as a DeadLock situation
     * since the main thread which has already acquired lock once is again trying to acquire the lock again.
     */
    void innerMethod() {
        lock.lock();    //the main thread acquires lock for the 2nd time, only since it was a reentrant lock
        try {
            System.out.println("Inside the inner method");
        } finally {
            lock.unlock();  //the main thread releases the lock which it had acquired for the 2nd time
        }
    }
}
