package dev.mayankg.multithreading.m1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Producer-Consumer problem
 */
public class BlockingQueue {
    private Queue<Integer> queue;
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public boolean add(int item) {
        synchronized (queue) {
            while (queue.size() == capacity) try {
                queue.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            queue.add(item);
            queue.notifyAll();  //notify all the threads which are in waiting state (due to remove)
            return true;
        }
    }

    public int remove() {
        synchronized (queue) {
            while (queue.isEmpty()) try {
                queue.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer elem = queue.poll();
            notifyAll();
            return elem;
        }
    }
}