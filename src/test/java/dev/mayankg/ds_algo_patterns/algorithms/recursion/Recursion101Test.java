package dev.mayankg.ds_algo_patterns.algorithms.recursion;

import dev.mayankg.ds_algo_patterns.dataStructures.util.Pair;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

class Recursion101Test {

    @AfterEach
    void printLineBreaker() {
        System.out.println("-------------------------------");
    }

    @Test
    void testPrintingFibonacciSequenceForNTerms() {
        int n = 10;
        String fibSeriesForN = Recursion101.fibonacciSequenceForNTerms(n);
        Assertions.assertEquals("0 1 1 2 3 5 8 13 21 34", fibSeriesForN.trim());
    }

    @Test
    void testXPowerN() {
        int x = 2, n = 7;
        Assertions.assertEquals(128, Recursion101.calcXPowerN(x, n));
    }

    @Test
    void testTowerOfHanoiProblem() {
        int n = 3; //try with 1, 2 and 3 to understand better
        String source = "A", helper = "B", destination = "C";
        int count = Recursion101.theTowerOfHanoiProblem(n, source, helper, destination);
        Assertions.assertEquals(((int) Math.pow(2, n)) - 1, count);
    }

    @Test
    void testReverseString() {
        String str = "abcd", ans = "dcba";
        Assertions.assertEquals(ans, Recursion101.reverseString(str));
    }

    @Test
    void testFindFirstAndLastOccurrences() {
        String str = "abaacdaefaah";
        Pair<Integer, Integer> ansPair =
                Recursion101.findFirstAndLastOccurrence(str, 'a', 0, -1, -1);

        Assertions.assertNotNull(ansPair);
        Assertions.assertEquals(0, (int) ansPair.get_1());
        Assertions.assertEquals(str.length() - 2, (int) ansPair.get_2());
    }

    @Test
    void testIsStrictlyIncreasinglySortedArray() {
        int[] testArr = new int[]{1, 2, 3, 4, 5};
        Assertions.assertTrue(Recursion101.isStrictlyIncreasingArr(testArr, testArr.length - 1));

        testArr = new int[]{1, 2, 3, 4, 4};
        Assertions.assertFalse(Recursion101.isStrictlyIncreasingArr(testArr, testArr.length - 1));

        testArr = new int[]{1, 2, 8, 5, 3};
        Assertions.assertFalse(Recursion101.isStrictlyIncreasingArr(testArr, testArr.length - 1));

        testArr = new int[]{1, 3, 5, 7, 9};
        Assertions.assertTrue(Recursion101.isStrictlyIncreasingArr(testArr, testArr.length - 1));
    }

    @Test
    void testMoveAllOccurrenceOfACharAtEnd() {
        String str = "axbcxxd", ans = "abcdxxx";
        char ch = 'x';
        String actual = Recursion101.moveAllOccurrenceOfACharAtEnd(str, ch, 0, 0, "");
        Assertions.assertEquals(ans, actual);
    }

    @Test
    void testRemoveDuplicatesFromString() {
        String str = "abbccdda", ans = "abcd";
        String actual = Recursion101.removeDuplicatesFromString(str, 0, new boolean[26], "");
        Assertions.assertEquals(ans, actual);
    }

    @Test
    void testAllSubsequenceOfString() {
        String str = "abcd";
        int count = Recursion101.printAllSubsequenceOfString(str, 0, "");
        Assertions.assertEquals((int) Math.pow(2, str.length()), count);
    }

    @Test
    void testAllUniqueSubsequenceOfString() {
        String str = "aaa";
        int count = Recursion101.printAllUniqueSubsequenceOfString(str, 0, "", new HashSet<>());
        Assertions.assertEquals(4, count);
    }

    @Test
    void testPrintAllKeypadCombinations() {
        String str = "23";
        String[] kpc = new String[]{".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
        int count = Recursion101.printAllKeypadCombinations(str, 0, "", kpc);
        Assertions.assertEquals(9, count);
    }
}