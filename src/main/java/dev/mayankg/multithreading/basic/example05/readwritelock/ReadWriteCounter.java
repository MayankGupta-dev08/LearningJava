package dev.mayankg.multithreading.basic.example05.readwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * This class demonstrates the use of ReadWriteLock to manage concurrent access to a shared resource. <br>
 * - **ReentrantReadWriteLock**: A ReadWriteLock maintains a pair of associated locks, one for read-only operations and one for writing. <br>
 * - **ReadWriteLock**: Allows multiple readers or one writer at a time. <br>
 * - **readLock**: Acquired for read operations. Multiple threads can acquire the read lock as long as no thread holds the write lock. <br>
 * - **writeLock**: Acquired for write operations. Only one thread can acquire the write lock, and no other thread can acquire the read or write lock while the write lock is held. <br>
 */
class ReadWriteCounter {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    private int count = 0;

    public static void main(String[] args) throws InterruptedException {
        var readWriteCounter = new ReadWriteCounter();

        Runnable writeTask = () -> {
            for (int i = 0; i < 10; i++) {
                readWriteCounter.increment();
                System.out.println(Thread.currentThread().getName() + " incremented the count");
            }
        };

        Runnable readTask = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " count=" + readWriteCounter.getCount());
            }
        };

        Thread writerThread = new Thread(writeTask, "Increment-Thread0");
        Thread readerThread1 = new Thread(readTask, "GetCount-Thread1");
        Thread readerThread2 = new Thread(readTask, "GetCount-Thread2");

        writerThread.start();
        readerThread1.start();
        readerThread2.start();

        writerThread.join();
        readerThread1.join();
        readerThread2.join();

        System.out.println("Final count: " + readWriteCounter.getCount());
    }

    public void increment() {
        try {
            writeLock.lock();
            count++;
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount() {
        try {
            readLock.lock();
            return count;
        } finally {
            readLock.unlock();
        }
    }
}