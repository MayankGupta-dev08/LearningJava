package dev.mayankg.ds_algo_patterns.algorithms.sorting;

/**
 * Bubble Sort aka Sinking Sort <br>
 * Time Complexity: O(n^2) <br>
 * Space Complexity: O(1) <br>
 * Stable: Yes <br>
 * In-Place: Yes <br>
 */
@SuppressWarnings({"unused"})
public final class BubbleSort {

    /**
     * Repeatedly swap the adjacent elements if they are in wrong order. <br>
     * For asc order --> if a[j] > a[j+1] then swap a[j] and a[j+1]
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        int N = arr.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (!SortingUtil.less(arr[j], arr[j + 1]))
                    SortingUtil.swap(arr, j, j + 1);
            }
        }
    }
}