package dev.mayankg.ds_algo_patterns.dataStructures.priorityqueue;


/**
 * MaxPriorityQueue using Binary Heap <br>
 * Time Complexity: O(logN) for insert() and delMax(), whereas O(1) for max() <br>
 */
@SuppressWarnings({"unchecked", "unused"})
class MaxPriorityQueue<T extends Comparable<T>> implements MaxPQ<T> {
    private T[] pq;
    private int N = 0;  // No. of elements in the PQ, 1-based index

    public MaxPriorityQueue(int capacity) {
        pq = (T[]) new Object[capacity + 1];
    }

    @Override
    public void insert(T item) {
        pq[++N] = item;
        swim(N);
    }

    @Override
    public T delMax() {
        T max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N + 1] = null;
        return max;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public T max() {
        return pq[1];
    }

    private void swim(int n) {
        while (n > 1 && less(n / 2, n)) {
            exch(n / 2, n);
            n = n / 2;
        }
    }

    private void sink(int i) {
        while (2 * i <= N) {
            int j = 2 * i;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(i, j)) {
                break;
            }
            exch(i, j);
            i = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}
