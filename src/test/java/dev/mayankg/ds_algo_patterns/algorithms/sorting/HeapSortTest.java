package dev.mayankg.ds_algo_patterns.algorithms.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    @Test
    void testSort() {
        Integer[] arr = {3, 5, 1, 2, 4};
        HeapSort.sort(arr);
        Integer[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arr);
    }

    @Test
    void testSortWithDuplicates() {
        Integer[] arr = {3, 5, 1, 2, 3, 4, 1};
        HeapSort.sort(arr);
        Integer[] expected = {1, 1, 2, 3, 3, 4, 5};
        assertArrayEquals(expected, arr);
    }

    @Test
    void testSortWithNegativeNumbers() {
        Integer[] arr = {3, -5, 1, -2, 4, 0};
        HeapSort.sort(arr);
        Integer[] expected = {-5, -2, 0, 1, 3, 4};
        assertArrayEquals(expected, arr);
    }

    @Test
    void testSortWithAlreadySortedArray() {
        Integer[] arr = {1, 2, 3, 4, 5};
        HeapSort.sort(arr);
        Integer[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arr);
    }

    @Test
    void testSortWithSingleElementArray() {
        Integer[] arr = {1};
        HeapSort.sort(arr);
        Integer[] expected = {1};
        assertArrayEquals(expected, arr);
    }

    @Test
    void testSortWithEmptyArray() {
        Integer[] arr = {};
        HeapSort.sort(arr);
        Integer[] expected = {};
        assertArrayEquals(expected, arr);
    }

    @Test
    void testSortWithStringArray() {
        String[] arr = {"banana", "apple", "cherry", "date"};
        HeapSort.sort(arr);
        String[] expected = {"apple", "banana", "cherry", "date"};
        assertArrayEquals(expected, arr);
    }

    @Test
    void testSortWithLargeNumbers() {
        Integer[] arr = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, 1};
        HeapSort.sort(arr);
        Integer[] expected = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE};
        assertArrayEquals(expected, arr);
    }

    @Test
    void testSortWithAllElementsSame() {
        Integer[] arr = {1, 1, 1, 1, 1};
        HeapSort.sort(arr);
        Integer[] expected = {1, 1, 1, 1, 1};
        assertArrayEquals(expected, arr);
    }
}