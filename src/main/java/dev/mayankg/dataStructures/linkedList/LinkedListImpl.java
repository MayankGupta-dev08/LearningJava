package dev.mayankg.dataStructures.linkedList;

import java.util.NoSuchElementException;

/**
 * My implementation of LinkedList
 */
class LinkedListImpl<T> implements MyLinkedList<T> {
    private Node head;
    private int size;

    @Override
    public void addFirst(T item) {
        Node node = addInEmptyLinkedList(item);
        if (node == null) return;

        node.next = head;
        head = node;
    }

    @Override
    public void addLast(T item) {
        Node node = addInEmptyLinkedList(item);
        if (node == null) return;

        Node temp = head;   //to reach lastNode
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("LinkedList is empty!!");

        head = head.next;
        size--; //garbage collector will take care of the prev head
    }

    @Override
    public void removeLast() {
        if (isEmpty()) throw new NoSuchElementException("LinkedList is empty!!");

        Node currNode = head;
        size--;
        if (currNode.next == null) { //only 1 node in LL
            head = null;
            return;
        }

        while (currNode.next.next != null) {    //more than 1 node in LL
            currNode = currNode.next;
        }   //to reach to 2ndLastNode
        currNode.next = null;
    }

    @Override
    public String toString() {
        Node currNode = head;
        StringBuilder sb = new StringBuilder("LL: [");
        while (currNode != null) {
            sb.append(currNode.val + " -> ");
            currNode = currNode.next;
        }
        return sb.append("null]").toString();
    }

    public T get(int idx) {
        if (idx >= size || idx < 0) throw new IndexOutOfBoundsException("Index out of bounds!!");

        Node iThNode = getIthNode(idx);
        if (iThNode == null) throw new NoSuchElementException("LinkedList is empty!!");

        return (T) iThNode.val;
    }

    public void insert(int idx, T item) {
        if (idx >= size || idx < 0) throw new IndexOutOfBoundsException("Index out of bounds!!");
        
        if(idx==0) {
            addFirst(item);
            return;
        }

    }

    public void remove(int idx) {
        if (idx >= size || idx < 0) throw new IndexOutOfBoundsException("Index out of bounds!!");

        if (idx == 0) {
            head = null;
            return;
        }

        Node iM1Node = getIthNode(idx - 1);
        iM1Node.next = iM1Node.next.next;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;

        return get(size - 1);
    }

    private Node addInEmptyLinkedList(T item) {
        Node node = new Node(item);
        size++;
        if (isEmpty()) {
            head = node;
            return null;
        }
        return node;
    }

    private Node getIthNode(int idx) {
        int i = 0;
        Node node = head;   //idx=5 --> i=6
        while (i < idx) {
            node = node.next;
            i++;
        }
        return node;
    }

    private static class Node<T> {
        T val;
        Node next;

        public Node(T val) {
            this.val = val;
        }

        public Node(T val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}