package dev.mayankg.ds_algo_patterns.algorithms.sorting;

/**
 * Selection Sort <br>
 * Time Complexity: O(n^2) <br>
 * Space Complexity: O(1) <br>
 * Stable: No <br>
 * In-Place: Yes <br>
 */
@SuppressWarnings({"unused"})
public final class SelectionSort {

    /**
     * Consider sorted part of array (nothing at the beginning) and unsorted part of array (everything else). <br>
     * Find the min and send it to the sorted part of the array. Reduce the scope of unsorted array and repeat. <br>
     * For asc order --> if a[j] < a[minIndex] then minIndex = j
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        int N = arr.length;
        for (int i = 0; i < N - 1; i++) {
            int minIndex = i;
            for (int j = i; j < N; j++) {
                if (SortingUtil.less(arr[j], arr[minIndex]))
                    minIndex = j;
            }
            SortingUtil.swap(arr, i, minIndex);
        }
    }
}