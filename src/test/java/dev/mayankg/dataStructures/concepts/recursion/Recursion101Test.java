package dev.mayankg.dataStructures.concepts.recursion;

import org.junit.Assert;
import org.junit.Test;

public class Recursion101Test {

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
        String src = "A", hlpr = "B", dest = "C";
        int count = Recursion101.theTowerOfHanoiProblem(n, src, hlpr, dest);
        Assert.assertEquals(((int) Math.pow(2, n)) - 1, count);
    }

    @Test
    public void testReverseString() {
        String str = "abcd", ans = "dcba";
        Assert.assertEquals(ans, Recursion101.reverseString(str));
    }
}