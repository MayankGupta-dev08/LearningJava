package dev.mayankg.ds_algo_patterns.algorithms.recursion;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class RecursionAdvTest {

    @AfterEach
    void printLineBreaker() {
        System.out.println("-------------------------------");
    }

    @Test
    void printAllPermutationOfString() {
        RecursionAdv.printAllPermutationOfString("abc", "");
    }

    @Test
    void countPathsInMaze() {
        int n = 3, m = 3;
        int expected = 6;
        Assertions.assertEquals(expected, RecursionAdv.countPathsInMaze(n, m, 0, 0));
    }

    @Test
    void tilingProblem() {
        int n = 4, m = 2;
        int expected = 5;
        Assertions.assertEquals(expected, RecursionAdv.tilingProblem(n, m));
    }

    @Test
    void callingGuestInPartyProblem() {
        int n = 4;
        int expected = 10;
        Assertions.assertEquals(expected, RecursionAdv.callingGuestInPartyProblem(n));
    }

    @Test
    void printSubsets() {
        int n = 3;
        ArrayList<Integer> subsets = new ArrayList<>();
        RecursionAdv.printSubsets(n, subsets);
    }
}