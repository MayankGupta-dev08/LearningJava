package dev.mayankg.dataStructures.queue;

import java.util.Stack;

// Using O(n) approach for push and O(1) for peek and dequeue
class QueueImpl2Stacks implements MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public QueueImpl2Stacks() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    @Override
    public void enqueue(int item) {
        if (s1.isEmpty()) {
            s1.add(item);
            System.out.println(item + ": added in the queue.");
            return;
        }
        //adding all the elements in s2 1by1 --> they get arranged in LIFO
        while (!s1.isEmpty()) s2.add(s1.pop());
        //Now adding the new item in s1 such that it is at the bottom of the stack
        s1.add(item);
        System.out.println(item + ": added in the queue.");
        //Now transferring all the elements in s1 back such that they are arranged in FIFO
        while (!s2.isEmpty()) s1.add(s2.pop());

    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Can't remove anything!!");
            return -1;
        }
        return s1.pop();
    }

    @Override
    public boolean isEmpty() {
        return s1.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int peek() {
        return s1.peek();
    }

    @Override
    public int size() {
        return s1.size();
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "Queue is empty!";

        StringBuilder sb = new StringBuilder("Queue: [");
        for (int i = s1.size() - 1; i >= 0; i--) {
            sb.append(s1.get(i));
            if (i != 0) sb.append(", ");
        }
        return sb.append("]").toString();
    }
}