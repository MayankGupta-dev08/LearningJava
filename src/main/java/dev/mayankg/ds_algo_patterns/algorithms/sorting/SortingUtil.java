package dev.mayankg.ds_algo_patterns.algorithms.sorting;

@SuppressWarnings("unused")
public final class SortingUtil {

    /**
     * Swaps the elements at the specified positions in the specified array.
     *
     * @param T the class of the objects in the array
     * @param arr the array in which to swap elements
     * @param i   the index of one element to be swapped
     * @param j   the index of the other element to be swapped
     */
    static <T> void swap(T[] arr, int i, int j) {
        if (arr == null || i < 0 || j < 0 || i >= arr.length || j >= arr.length) {
            throw new IllegalArgumentException("Invalid index or null array");
        }
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Returns true if the first argument is less than the second argument.
     *
     * @param T the type of the arguments being compared
     * @param a   the first object to be compared
     * @param b   the second object to be compared
     * @return true if the first argument is less than the second argument, false otherwise
     */
    static <T extends Comparable<T>> boolean less(T a, T b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Arguments must not be null");
        }
        return a.compareTo(b) < 0;
    }
}