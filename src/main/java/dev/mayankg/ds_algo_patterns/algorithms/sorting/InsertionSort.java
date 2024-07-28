package dev.mayankg.ds_algo_patterns.algorithms.sorting;

/**
 * Insertion Sort <br>
 * Time Complexity: O(n^2) <br>
 * Space Complexity: O(1) <br>
 * Stable: Yes <br>
 * In-Place: Yes <br>
 */
@SuppressWarnings({"unused"})
public final class InsertionSort {

    /**
     * Consider arr[0] to be sorted part of the array (an array with a single element is sorted by default) and arr[1 to N-1] to be unsorted. <br>
     * Iterate from 1 to (N-1) and for each i, place the arr[i] to the correct position in the sorted array. <br>
     * For asc order --> for key = arr[i], arr[j] = arr[j-1] and j-- until j>0 && key >= arr[j-1] <br>
     *
     * @param <E> the type of elements to be sorted, which must be comparable
     * @param arr the array to be sorted
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            E key = arr[i];
            int j = i;
            while (j > 0 && SortingUtil.less(key, arr[j - 1])) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = key;
        }
    }
}