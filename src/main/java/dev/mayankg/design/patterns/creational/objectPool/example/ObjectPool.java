package dev.mayankg.design.patterns.creational.objectPool.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Supplier;

class ObjectPool<T extends Poolable> {
    private BlockingQueue<T> availablePool;

    public ObjectPool(Supplier<T> creator, int count) {
        availablePool = new LinkedBlockingDeque<>();
        for (int i = 0; i < count; i++)
            availablePool.offer(creator.get());
    }

    public T get() {
        try {
            return availablePool.take();
        } catch (InterruptedException e) {
            System.err.println("GET was interrupted!!");
        }
        return null;
    }

    public void release(T object) {
        object.reset();
        try {
            availablePool.put(object);
        } catch (InterruptedException e) {
            System.err.println("GET was interrupted!!");
        }
    }
}