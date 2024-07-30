package dev.mayankg.ds_algo_patterns.algorithms.sorting;

import java.util.Comparator;

/**
 * Quick Sort <br>
 * Time Complexity: O(n^2) in Worst case & Θ(n log(n)) in Avg Case<br>
 * Space Complexity: O(log(n)) <br>
 * Stable: No <br>
 * In-Place: Yes <br>
 */
@SuppressWarnings({"unused"})
public final class QuickSort {

    /**
     * Quick Sort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot i.e., Send all the smaller elements from pivot to its left and all the bigger elements from pivot to its right.<p>
     * 1. Pick an element as pivot. <br>
     * 2. Partition the array around the pivot. <br>
     * 3. Recursively sort the left and right halves of the array.
     *
     * @param arr the array to be sorted
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int low, int high) {
        if (low >= high) return;

        int pivotIdx = partition(arr, low, high);
        sort(arr, low, pivotIdx - 1);
        sort(arr, pivotIdx + 1, high);
    }

    /**
     * Partition the array around the pivot element. We will consider the last element of the partition as pivot.
     */
    private static <E extends Comparable<E>> int partition(E[] arr, int low, int high) {
        E pivot = arr[high];
        int i = low - 1;    //helps in arranging the smaller elements (initially, assuming nothing is smaller than pivot)
        for (int j = low; j < high; j++) {
            if (SortingUtil.less(arr[j], pivot)) {  // arr[j] < pivot
                i++;
                SortingUtil.swap(arr, i, j);
            }
        }

        int pivotIdx = i + 1;
        SortingUtil.swap(arr, pivotIdx, high); // place pivot at correct position
        return pivotIdx;
    }

    /**
     * Quick sort with comparators
     */
    public static <E> void sort(E[] arr, Comparator<E> comparator) {
        sort(arr, 0, arr.length - 1, comparator);
    }

    private static <E> void sort(E[] arr, int low, int high, Comparator<E> comparator) {
        if (low >= high) return;

        int pivotIdx = partition(arr, low, high, comparator);
        sort(arr, low, pivotIdx - 1, comparator);
        sort(arr, pivotIdx + 1, high, comparator);
    }

    private static <E> int partition(E[] arr, int low, int high, Comparator<E> comparator) {
        E pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (SortingUtil.less(arr[j], pivot, comparator)) {
                i++;
                SortingUtil.swap(arr, i, j);
            }
        }
        int pivotIdx = i + 1;
        SortingUtil.swap(arr, pivotIdx, high);
        return pivotIdx;
    }
}