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

    /**
     * Bottom-Up Merge Sort is an iterative version of the Merge Sort algorithm.
     * It starts by treating each element as a separate list of size 1, and then repeatedly merges the lists until a single list remains.
     * Drawback: It requires extra space for the auxiliary array.
     */
    public static final class BottomUpMergeSort {

        /**
         * @param <E> the type of elements to be sorted, which must be comparable
         * @param arr the array to be sorted
         */
        public static <E extends Comparable<E>> void sort(E[] arr) {
            int N = arr.length;
            E[] aux = (E[]) new Comparable[N];

            for (int size = 1; size < N; size *= 2) {   // Iterate over different sizes of sub-arrays (1, 2, 4, 8, ...)
                for (int low = 0; low < N - size; low += 2 * size) {
                    int mid = low + size - 1;
                    int high = Math.min(low + 2 * size - 1, N - 1); // Ensure high does not go out of bounds
                    merge(arr, aux, low, mid, high);
                }
            }
        }

        /**
         * Merges two sorted subarrays into a single sorted subarray.
         *
         * @param <E>  the type of elements to be sorted, which must be comparable
         * @param arr  the original array containing the subarrays to be merged
         * @param aux  an auxiliary array used for merging
         * @param low  the starting index of the first subarray
         * @param mid  the ending index of the first subarray (and mid + 1 is the starting index of the second subarray)
         * @param high the ending index of the second subarray
         */
        private static <E extends Comparable<E>> void merge(E[] arr, E[] aux, int low, int mid, int high) {
            System.arraycopy(arr, low, aux, low, high - low + 1);

            int i = low, j = mid + 1;
            for (int k = low; k <= high; k++) {
                if (i > mid)
                    arr[k] = aux[j++]; // If the left subarray is exhausted, take from the right subarray
                else if (j > high)
                    arr[k] = aux[i++];   // If the right subarray is exhausted, take from the left subarray
                else if (SortingUtil.less(aux[j], aux[i]))
                    arr[k] = aux[j++];   // If the current element in the right subarray is smaller, take it
                else
                    arr[k] = aux[i++]; // Otherwise, take the current element in the left subarray
            }
        }
    }

}
