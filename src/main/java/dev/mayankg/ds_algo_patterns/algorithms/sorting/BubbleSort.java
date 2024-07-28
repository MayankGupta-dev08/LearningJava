package dev.mayankg.ds_algo_patterns.algorithms.sorting;

import jdk.jfr.Description;

/**
 * Bubble Sort aka Sinking Sort <br>
 * Time Complexity: O(n^2) <br>
 * Space Complexity: O(1) <br>
 * Stable: Yes <br>
 * In-Place: Yes <br>
 */
@SuppressWarnings({"unused"})
@Description("Bubble Sort aka Sinking Sort")
public class BubbleSort {

    /**
     * Repeatedly swap the adjacent elements if they are in wrong order.
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        int N = arr.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (SortingUtil.less(arr[j + 1], arr[j]))
                    SortingUtil.swap(arr, j, j + 1);
            }
        }
    }
}