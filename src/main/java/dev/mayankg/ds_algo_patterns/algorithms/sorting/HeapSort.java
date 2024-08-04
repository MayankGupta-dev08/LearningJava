package dev.mayankg.ds_algo_patterns.algorithms.sorting;


/**
 * Heap Sort implementation using Binary Heap <br>
 * Time complexity: O(NlogN) <br>
 * Space complexity: O(1) <br>
 * It is not a stable sort. <br>
 * Heap Sort is an in-place sorting algorithm with worst-case and average-case time complexity of O(NlogN). <br>
 * Heap Sort is 1-based index algorithm, whereas array is 0-based index.
 */
@SuppressWarnings({"unused"})
public final class HeapSort {
    private HeapSort() {
    }

    /**
     * Sort the array in asc order using Heap Sort algorithm (using Max Heap). <br>
     * Building the heap takes O(N) time and sorting the array takes O(NlogN) time. <br>
     * Build heap using bottom-up approach and then sort the array using sink operation. <br>
     * @param arr Array to be sorted
     * @param <T> Type of array elements
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        int N = arr.length;
        for (int k = N / 2; k >= 1; k--) {  // Build heap using sink operation
            sink(arr, k, N);
        }
        while (N > 1) { // Sort the array using sink operation
            swap(arr, 1, N);
            sink(arr, 1, --N);
        }
    }

    private static <T extends Comparable<T>> void sink(T[] arr, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(arr, j, j + 1)) j++;
            if (!less(arr, k, j)) break;
            swap(arr, k, j);
            k = j;
        }
    }

    // Both i and j are subtracted by 1 to convert 1-based index to 0-based index, as arr is 0-based and algo is 1-based
    private static <T extends Comparable<T>> boolean less(T[] arr, int i, int j) {
        return arr[i - 1].compareTo(arr[j - 1]) < 0;
    }

    // Both i and j are subtracted by 1 to convert 1-based index to 0-based index, as arr is 0-based and algo is 1-based
    private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i - 1];
        arr[i - 1] = arr[j - 1];
        arr[j - 1] = temp;
    }
}