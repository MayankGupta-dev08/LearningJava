package dev.mayankg.ds_algo_patterns.dataStructures.linkedList;

import dev.mayankg.dataStructures.linkedList.MyLinkedList;

import java.util.NoSuchElementException;

/**
 * My implementation of LinkedList
 */
class LinkedListImpl<T> implements dev.mayankg.dataStructures.linkedList.MyLinkedList<T> {
    Node<T> head;
    private int size;

    public LinkedListImpl() {
        head = null;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node<T> node = addInEmptyLinkedList(item);
        if (node == null) return;

        node.next = head;
        head = node;
    }

    @Override
    public void addLast(T item) {
        Node<T> node = addInEmptyLinkedList(item);
        if (node == null) return;

        Node<T> temp = head;   //to reach lastNode
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

        Node<T> currNode = head;
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
        Node<T> currNode = head;
        StringBuilder sb = new StringBuilder("LL: [");
        while (currNode != null) {
            sb.append(currNode.val + " -> ");
            currNode = currNode.next;
        }
        return sb.append("null]").toString();
    }

    public T get(int idx) {
        if (idx >= size || idx < 0) throw new IndexOutOfBoundsException("Index out of bounds!!");

        Node<T> iThNode = getIthNode(idx);
        if (iThNode == null) throw new NoSuchElementException("LinkedList is empty!!");

        return (T) iThNode.val;
    }

    /**
     * to insert newNode anywhere in the linkedList using index
     */
    @Override
    public void insert(int idx, T item) {
        if (idx > size || idx < 0) throw new IndexOutOfBoundsException("Index out of bounds!!");

        if (idx == 0) {
            addFirst(item);
            return;
        }

        Node<T> nodeIM1 = getIthNode(idx - 1);
        Node<T> nodeITh = nodeIM1.next;

        Node<T> newNode = new Node<>(item);
        newNode.next = nodeITh;
        nodeIM1.next = newNode;
        size++;
    }

    /**
     * to remove anywhere in the linkedList using index
     */
    @Override
    public void remove(int idx) {
        if (idx >= size || idx < 0) throw new IndexOutOfBoundsException("Index out of bounds!!");

        size--;
        if (idx == 0) {
            if (head.next == null)
                head = null;
            else
                head = head.next;
            return;
        }

        Node<T> iM1Node = getIthNode(idx - 1);
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

    private Node<T> addInEmptyLinkedList(T item) {
        Node<T> node = new Node<>(item);
        size++;
        if (isEmpty()) {
            head = node;
            return null;
        }
        return node;
    }

    private Node<T> getIthNode(int idx) {
        int i = 0;
        Node<T> node = head;//idx=5 --> i=6
        while (i < idx) {
            node = node.next;
            i++;
        }
        return node;
    }

    static class Node<T> {
        T val;
        Node<T> next;

        public Node(T val) {
            this.val = val;
        }

        public Node(T val, Node<T> next) {
            this.val = val;
            this.next = next;
        }
    }
}