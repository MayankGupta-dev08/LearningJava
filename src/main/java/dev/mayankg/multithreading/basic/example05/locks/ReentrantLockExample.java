package dev.mayankg.multithreading.basic.example05.locks;

import java.util.concurrent.locks.ReentrantLock;


/**
 * A ReentrantLock is owned by the thread last successfully locking, but not yet unlocking it.
 * A thread invoking lock will return, successfully acquiring the lock, when the lock is not owned by another thread.
 * The method will return immediately if the current thread already owns the lock.
 * This can be checked using methods isHeldByCurrentThread, and getHoldCount.
 */
class ReentrantLockExample {
    private final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        var reentrantLockExample = new ReentrantLockExample();
        reentrantLockExample.outerMethod();
    }

    void outerMethod() {
        lock.lock();    //the main thread acquires lock for the 1st time
        try {
            System.out.println("Inside the outer method");
            innerMethod();
        } finally {
            lock.unlock();
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
            lock.unlock();
        }
    }
}
