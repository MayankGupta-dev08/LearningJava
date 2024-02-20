package dev.mayankg.design.patterns.creational.objectPool.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Supplier;

/**
 * Object Pool, here we are pre-creating objects in the pool
 */
class ObjectPool<T extends Poolable> {
    private BlockingQueue<T> availablePool;

    public ObjectPool(Supplier<T> creator, int preCache) {
        availablePool = new LinkedBlockingDeque<>();
        for (int i = 0; i < preCache; i++)
            availablePool.offer(creator.get());
    }

    /*GET must decide what to do when the pool is empty: wait or create a new object and return it.*/
    public T get() {
        try {
            return availablePool.take();
        } catch (InterruptedException e) {
            // Here we are waiting if the pool is empty. This has a -ve server impact.
            System.err.println("GET was interrupted!! Waiting on the pooled queue");
        }
        return null;
    }

    /*RELEASE is putting the obj back in the pool after its no more needed to be reused again sometime.*/
    public void release(T object) {
        object.reset();
        try {
            availablePool.put(object);
        } catch (InterruptedException e) {
            System.err.println("PUT was interrupted!! Waiting on the pooled queue");
        }
    }
}