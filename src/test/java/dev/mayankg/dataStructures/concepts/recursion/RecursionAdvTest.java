package dev.mayankg.dataStructures.concepts.recursion;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RecursionAdvTest {

    @Test
    public void printAllPermutationOfString() {
        RecursionAdv.printAllPermutationOfString("abc", "");
    }

    @Test
    public void countPathsInMaze() {
        int n = 3, m = 3;
        int expected = 6;
        Assert.assertEquals(expected, RecursionAdv.countPathsInMaze(n, m, 0, 0));
    }

    @Test
    public void tilingProblem() {
        int n = 4, m = 2;
        int expected = 5;
        Assert.assertEquals(expected, RecursionAdv.tilingProblem(n, m));
    }

    @Test
    public void callingGuestInPartyProblem() {
        int n = 4;
        int expected = 10;
        Assert.assertEquals(expected, RecursionAdv.callingGuestInPartyProblem(n));
    }

    @Test
    public void printSubsets() {
        int n = 3;
        ArrayList<Integer> subsets = new ArrayList<>();
        RecursionAdv.printSubsets(n, subsets);
    }
}