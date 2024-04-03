package dev.mayankg.dataStructures.queue;

class QueueImplLnkL implements MyQueue {
    private Node head;
    private Node tail;
    private int size;

    @Override
    public void enqueue(int item) {
        Node node = new Node(item);
        System.out.println(item + ": added to the queue.");
        if (isEmpty()) {
            tail = head = node;
            size++;
            return;
        }
        tail.next = node;
        tail = node;
        size++;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Can't delete anything");
            return -1;
        }
        int front = head.val;
        if (head == tail) tail = null;  //single node remaining
        head = head.next;
        size--;
        return front;
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    @Override
    @Deprecated
    public boolean isFull() {
        return false;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!!");
            return -1;
        }
        return head.val;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
}