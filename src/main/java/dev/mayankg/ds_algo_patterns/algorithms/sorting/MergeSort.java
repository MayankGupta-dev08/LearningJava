package dev.mayankg.ds_algo_patterns.algorithms.sorting;

/**
 * Merge Sort <br>
 * Time Complexity: O(n log(n)) <br>
 * Space Complexity: O(n) <br>
 * Stable: Yes <br>
 * In-Place: No <br>
 */
@SuppressWarnings({"unused"})
public final class MergeSort {

    /**
     * Merge Sort is a Divide and Conquer algorithm. It divides the input array into two halves, calls itself for the two halves, and then merges the two sorted halves.
     * <p>
     * 1. Divide the array into two halves: left and right. <br>
     * 2. Recursively sort the left half and right half. <br>
     * 3. Merge the two sorted halves.
     *
     * @param arr the array to be sorted
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int i, int j) {
        if (i >= j) return;

        int mid = i + (j - i) / 2;
        sort(arr, i, mid);
        sort(arr, mid + 1, j);
        merge(arr, i, mid, j);
    }

    private static <E extends Comparable<E>> void merge(E[] arr, int left, int mid, int right) {
        E[] mergedArr = (E[]) new Comparable[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (SortingUtil.less(arr[i], arr[j]))
                mergedArr[k++] = arr[i++];
            else
                mergedArr[k++] = arr[j++];
        }

        while (i <= mid)
            mergedArr[k++] = arr[i++];

        while (j <= right)
            mergedArr[k++] = arr[j++];


        for (i = 0; i < k; i++)
            arr[left + i] = mergedArr[i];
    }
}
