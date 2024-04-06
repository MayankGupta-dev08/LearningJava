package dev.mayankg.dataStructures.concepts.recursion;

import org.junit.Assert;
import org.junit.Test;

public class Recursion101Test {
    private Recursion101 instance = new Recursion101();

    @Test
    public void testPrintingFibonacciSequenceForNTerms() {
        int n = 10;
        instance.fibonacciSequenceForNTerms(n);
    }

    @Test
    public void testXPowerN() {
        int x = 2, n = 7;
        Assert.assertEquals(128, instance.calcXPowerN(x, n));
    }
}