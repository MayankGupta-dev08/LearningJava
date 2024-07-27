package dev.mayankg.ds_algo_patterns.algorithms.searching;

/**
 * Binary search implementation
 */
@SuppressWarnings("unused")
class BinarySearch<E extends Comparable<E>> {
    private static final int DEFAULT_VALUE = -1;

    private BinarySearch() {
    }

    /**
     * Search for the key in a sorted array w or w/o duplicates in O(log n) time
     */
    public static <E extends Comparable<E>> int search(E[] arr, E key) {
        if (arr == null || arr.length == 0)
            return DEFAULT_VALUE;

        int low = 0;
        int high = arr.length - 1;

        int foundIndex = DEFAULT_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid].compareTo(key) == 0) {
                foundIndex = mid;
                break;
            }

            if (arr[mid].compareTo(key) < 0) {
                low = mid + 1;
            } else
                high = mid - 1;
        }

        if (foundIndex != DEFAULT_VALUE) {
            while (foundIndex > 0 && arr[foundIndex - 1].compareTo(key) == 0)
                foundIndex--;
        }

        return foundIndex;
    }
}
