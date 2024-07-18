package dev.mayankg.ds_algo_patterns.algorithms.backtracking;


import java.util.List;
import java.util.Scanner;

/**
 * Question: For a NxN chess board, we have N number of queens, and we have to place them on the board in such a manner that no two queens could attack each other.
 */
public class NQueens {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();

        List<List<String>> SolutionLists = solutionNQueens(N);
        for (List<String> solutionNQueen : SolutionLists) {

        }
    }

    /**
     * Approach: We will place the queens column wise such that each column has a queen and no two of them would be able to attack each other.
     * If we are not able to place the queen in a given column, then we would backtrack to the previous column and find the new position of the queen for that column (row-wise) and then move to the next column.
     * Once we have arrived at a solution, then we would again try from the start to find some more solution for this problem.
     * Hint: For 2<=N<=3 --> Not possible and for N=4 --> Ans=2 [{}, {}]
     */
    private static List<List<String>> solutionNQueens(int n) {
        return null;
    }
}