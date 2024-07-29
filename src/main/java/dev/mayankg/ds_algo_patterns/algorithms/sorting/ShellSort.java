package dev.mayankg.ds_algo_patterns.algorithms.sorting;

/**
 * Shell Sort aka Modified Insertion Sort (with gap) <br>
 * Time Complexity: O(n^2) in Worst case & Θ(n log(n)) in Avg Case<br>
 * Space Complexity: O(1) <br>
 * Stable: No <br>
 * In-Place: Yes <br>
 */
@SuppressWarnings({"unused"})
public final class ShellSort {

    /**
     * Sorts the array using the Shell sort algorithm.
     * The method uses the Shell's original gap sequence: N/2, N/4, ..., 1.
     * Shell sort behaves the same as Insertion sort but with a gap.
     *
     * @param <E> the type of elements to be sorted, which must be comparable
     * @param arr the array to be sorted
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        int N = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = N / 2; gap > 0; gap /= 2) {
            // Perform a gapped insertion sort for this gap size.
            for (int i = gap; i < N; i++) {
                E key = arr[i];
                int j = i;

                // Shift earlier gap-sorted elements up until the correct location for arr[i] is found
                while (j >= gap && SortingUtil.less(key, arr[j - gap])) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                // Put key (the original arr[i]) in its correct location
                arr[j] = key;
            }
        }
    }
}
