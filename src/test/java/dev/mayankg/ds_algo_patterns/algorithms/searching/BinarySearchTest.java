package dev.mayankg.ds_algo_patterns.algorithms.searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    @Test
    void testSearchIntegerArray() {
        Integer[] intArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        assertEquals(2, BinarySearch.search(intArray, 5), "Should return index of 5");
        assertEquals(7, BinarySearch.search(intArray, 15), "Should return index of 15");
        assertEquals(-1, BinarySearch.search(intArray, 20), "Should return -1 for element not present");
        assertEquals(0, BinarySearch.search(intArray, 1), "Should return index of 1");
        assertEquals(9, BinarySearch.search(intArray, 19), "Should return index of 19");
    }

    @Test
    void testSearchStringArray() {
        String[] strArray = {"apple", "banana", "cherry", "date", "fig", "grape"};

        assertEquals(1, BinarySearch.search(strArray, "banana"), "Should return index of 'banana'");
        assertEquals(3, BinarySearch.search(strArray, "date"), "Should return index of 'date'");
        assertEquals(-1, BinarySearch.search(strArray, "kiwi"), "Should return -1 for element not present");
        assertEquals(0, BinarySearch.search(strArray, "apple"), "Should return index of 'apple'");
        assertEquals(5, BinarySearch.search(strArray, "grape"), "Should return index of 'grape'");
    }

    @Test
    void testSearchEmptyArray() {
        Integer[] emptyArray = {};

        assertEquals(-1, BinarySearch.search(emptyArray, 5), "Should return -1 for an empty array");
    }

    @Test
    void testSearchSingleElementArray() {
        Integer[] singleElementArray = {42};

        assertEquals(0, BinarySearch.search(singleElementArray, 42), "Should return index of single element present");
        assertEquals(-1, BinarySearch.search(singleElementArray, 7), "Should return -1 for element not present in single element array");
    }

    @Test
    void testSearchNullArray() {
        assertEquals(-1, BinarySearch.search(null, 5), "Should return -1 for a null array");
    }

    @Test
    void testSearchDuplicateElements() {
        Integer[] arrayWithDuplicates = {1, 1, 1, 1, 1, 1, 1};

        assertEquals(0, BinarySearch.search(arrayWithDuplicates, 1), "Should return index of the first occurrence of 1");
    }
}