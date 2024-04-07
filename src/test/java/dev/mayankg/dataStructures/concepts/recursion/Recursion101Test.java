package dev.mayankg.dataStructures.concepts.recursion;

import dev.mayankg.dataStructures.util.Pair;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class Recursion101Test {
    @After
    public void printLineBreak() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    @Test
    public void testPrintingFibonacciSequenceForNTerms() {
        int n = 10;
        String fibSeriesForN = Recursion101.fibonacciSequenceForNTerms(n);
        Assert.assertEquals("0 1 1 2 3 5 8 13 21 34", fibSeriesForN.trim());
    }

    @Test
    public void testXPowerN() {
        int x = 2, n = 7;
        Assert.assertEquals(128, Recursion101.calcXPowerN(x, n));
    }

    @Test
    public void testTowerOfHanoiProblem() {
        int n = 3; //try with 1, 2 and 3 to understand better
        String source = "A", helper = "B", destination = "C";
        int count = Recursion101.theTowerOfHanoiProblem(n, source, helper, destination);
        Assert.assertEquals(((int) Math.pow(2, n)) - 1, count);
    }

    @Test
    public void testReverseString() {
        String str = "abcd", ans = "dcba";
        Assert.assertEquals(ans, Recursion101.reverseString(str));
    }

    @Test
    public void testFindFirstAndLastOccurrences() {
        String str = "abaacdaefaah";
        Pair<Integer, Integer> ansPair =
                Recursion101.findFirstAndLastOccurrence(str, 'a', 0, -1, -1);

        Assert.assertNotNull(ansPair);
        Assert.assertEquals(0, (int) ansPair.get_1());
        Assert.assertEquals(str.length() - 2, (int) ansPair.get_2());
    }

    @Test
    public void testIsStrictlyIncreasinglySortedArray() {
        int[] testArr = new int[]{1, 2, 3, 4, 5};
        Assert.assertTrue(Recursion101.isStrictlyIncreasingArr(testArr, testArr.length - 1));

        testArr = new int[]{1, 2, 3, 4, 4};
        Assert.assertFalse(Recursion101.isStrictlyIncreasingArr(testArr, testArr.length - 1));

        testArr = new int[]{1, 2, 8, 5, 3};
        Assert.assertFalse(Recursion101.isStrictlyIncreasingArr(testArr, testArr.length - 1));

        testArr = new int[]{1, 3, 5, 7, 9};
        Assert.assertTrue(Recursion101.isStrictlyIncreasingArr(testArr, testArr.length - 1));
    }

    @Test
    public void testMoveAllOccurrenceOfACharAtEnd() {
        String str = "axbcxxd", ans = "abcdxxx";
        char ch = 'x';
        String actual = Recursion101.moveAllOccurrenceOfACharAtEnd(str, ch, 0, 0, "");
        Assert.assertEquals(ans, actual);
    }

    @Test
    public void testRemoveDuplicatesFromString() {
        String str = "abbccdda", ans = "abcd";
        String actual = Recursion101.removeDuplicatesFromString(str, 0, new boolean[26], "");
        Assert.assertEquals(ans, actual);
    }

    @Test
    public void testAllSubsequenceOfString() {
        String str = "abcd";
        int count = Recursion101.printAllSubsequenceOfString(str, 0, "");
        Assert.assertEquals((int) Math.pow(2, str.length()), count);
    }

    @Test
    public void testAllUniqueSubsequenceOfString() {
        String str = "aaa";
        int count = Recursion101.printAllUniqueSubsequenceOfString(str, 0, "", new HashSet<>());
        Assert.assertEquals(4, count);
    }
}