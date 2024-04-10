package dev.mayankg.dataStructures.concepts.recursion;

public class RecursionAdv {
    public static void main(String[] args) {
//        printAllPermutationOfString("abc", "");
        System.out.println(countPathsInMaze(3, 4, 0, 0));
    }

    // O(n!), n is the length of the str --> n*(n-1)*(n-2)*...*1
    static void printAllPermutationOfString(String str, String ans) {
        if (str.isEmpty()) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String newStr = str.substring(0, i) + str.substring(i + 1);
            printAllPermutationOfString(newStr, ans + str.charAt(i));
        }
    }

    // to move from (0,0) to (n,m) in int[n][m] maze, such that movement is only allowed in right and downward directions
    // O(2^(n+m)), which is exponential which is bad --> a better solution will be using DP.
    static int countPathsInMaze(int n, int m, int i, int j) {
        if (i == n || j == m) return 0;
        if (i == n - 1 && j == m - 1) return 1;

        int downPaths = countPathsInMaze(n, m, i + 1, j);
        int rightPaths = countPathsInMaze(n, m, i, j + 1);
        return downPaths + rightPaths;
    }
}