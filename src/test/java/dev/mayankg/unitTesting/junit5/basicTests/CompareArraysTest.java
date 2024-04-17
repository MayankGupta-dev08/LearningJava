package dev.mayankg.unitTesting.junit5.basicTests;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CompareArraysTest {

    @BeforeAll
    static void setUpClass() {
        System.out.println("Setting Up the Test class");
    }

    @AfterAll
    static void cleanUpClass() {
        System.out.println("Cleaning Up the Test class");
    }

    @BeforeEach
    void initTest() {

    }

    @AfterEach
    void cleanUpTest() {

    }

    @Test
    @DisplayName("test sorting on a non-null array")
    void testSortArray_arrayNotNull() {
        int[] numbers = {19, 27, 5, 8};
        int[] expected = {5, 8, 19, 27};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test()
    @DisplayName("test sorting on a null array")
    void testSortArray_arrayNull() {
        int[] numbers = null;
        assertThrows(NullPointerException.class, () -> Arrays.sort((int[]) null));
    }
}