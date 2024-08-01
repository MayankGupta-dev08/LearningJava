package dev.mayankg.ds_algo_patterns.dataStructures.priorityqueue;

/**
 * Min Priority Queue implementation using Binary Heap <br>
 * Time complexity: O(logN) for insert and delMin <br>
 * Space complexity: O(n) <br>
 * MinPQ: Each parent node is smaller than its children.
 */
@SuppressWarnings({"unchecked", "unused"})
class MinPriorityQueue<T extends Comparable<T>> implements MinPQ<T> {
    private T[] pq;
    private int N = 0;  // No. of elements in the PQ, 1-based index

    public MinPriorityQueue(int capacity) {
        pq = (T[]) new Comparable[capacity + 1];
    }

    @Override
    public void insert(T item) {
        if (N == pq.length - 1) resize(2 * pq.length);
        pq[++N] = item;
        swim(N);    // heapify
    }

    @Override
    public T delMin() {
        if (isEmpty())
            throw new IllegalStateException("Priority queue underflow");

        T min = pq[1];
        swap(1, N--);
        sink(1);
        pq[N + 1] = null;   // Avoid loitering
        return min;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;  // N is 1-based index
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public T min() {
        if (isEmpty())
            throw new IllegalStateException("Priority queue underflow");

        return pq[1];
    }

    /**
     * Swim up the element to restore heap order. <br>
     * Time complexity: O(logN) <br>
     * Child's key becomes smaller key than its parent's key.
     * So, we exchange key in child with key in parent.
     * Continue until we reach the root or heap order is restored.
     */
    private void swim(int key) {
        while (key > 1 && greater(key / 2, key)) { //k=1 is the root and k/2 is the parent of k
            swap(key / 2, key);
            key = key / 2;
        }
    }

    /**
     * Sink down the element to restore heap order. <br>
     * Time complexity: O(logN) <br>
     * Parent's key becomes larger key than its children's key.
     * So, we exchange key in parent with key in larger child.
     * Continue until we reach the leaf or heap order is restored.
     */
    private void sink(int key) {
        while (2 * key <= N) {
            int j = 2 * key;
            if (j < N && greater(j, j + 1)) j++;
            if (!greater(key, j)) break;
            swap(key, j);
            key = j;
        }
    }

    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void swap(int i, int j) {
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Comparable[capacity];
        for (int i = 1; i <= N; i++) temp[i] = pq[i];
        pq = temp;
    }
}
