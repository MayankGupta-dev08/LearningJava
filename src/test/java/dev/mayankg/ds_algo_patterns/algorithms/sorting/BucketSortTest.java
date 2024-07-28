package dev.mayankg.ds_algo_patterns.algorithms.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BucketSortTest {

    @Test
    void sort1() {
        int[] arr = {29, 25, 3, 49, 9, 37, 21, 43};
        sortArrayUsingBucketSortAlgo(arr);
        assertArrayEquals(new int[]{3, 9, 21, 25, 29, 37, 43, 49}, arr);
    }

    @Test
    void sort2() {
        int[] arr = {29, 25, 3, 49, 9, 37, 21, 43, 1, 2, 3, 4, 5, 6, 7, 8};
        sortArrayUsingBucketSortAlgo(arr);
        assertArrayEquals(new int[]{1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 21, 25, 29, 37, 43, 49}, arr);
    }

    @Test
    void sort3() {
        int[] arr = {29, 25, 3, 49, 9, 37, 21, 43, 1, 2, 3, 4, 5, 6, 7, 8, 0};
        sortArrayUsingBucketSortAlgo(arr);
        assertArrayEquals(new int[]{0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 21, 25, 29, 37, 43, 49}, arr);
    }

    @Test
    void sort4() {
        int[] arr = {7, 5, 3, 8, 9, 2, 4, 1, 0, 6};
        sortArrayUsingBucketSortAlgo(arr);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, arr);
    }

    private static void sortArrayUsingBucketSortAlgo(int[] arr) {
        System.out.println("\nBefore Sorting: " + Arrays.toString(arr));
        BucketSort.sort(arr);
        System.out.println("\nAfter Sorting: " + Arrays.toString(arr));
    }
}