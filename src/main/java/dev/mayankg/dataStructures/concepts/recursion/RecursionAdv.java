package dev.mayankg.dataStructures.concepts.recursion;

class RecursionAdv {
    /**
     * O(n!), n is the length of the str --> n*(n-1)*(n-2)*...*1
     */
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

    /**
     * to move from (0,0) to (n,m) in int[n][m] maze, such that movement is only allowed in right and downward directions
     * O(2^(n+m)), which is exponential which is bad --> a better solution will be using DP.
     */
    static int countPathsInMaze(int n, int m, int i, int j) {
        if (i == n || j == m) return 0;
        if (i == n - 1 && j == m - 1) return 1;

        int downPaths = countPathsInMaze(n, m, i + 1, j);
        int rightPaths = countPathsInMaze(n, m, i, j + 1);
        return downPaths + rightPaths;
    }

    /**
     * For a floor of nxm, if a tile is of 1xm then possible no. of ways for tiling
     * Base cases are important in this question. This solution can also be optimized using DP.
     */
    static int tilingProblem(int n, int m) {
        if (n == m) return 2;   //only 2 possibilities (1st: both Horizontal, and 2nd: both Vertical)
        if (m > n) return 1;    //all tiles can be placed only in 1 way (horizontally)

        int horizontally = tilingProblem(n - 1, m);
        int vertically = tilingProblem(n - m, m);
        return horizontally + vertically;
    }

    /**
     * Find the no. Of ways in which u can invite (n) no. Of people in the party, either as single or as a pair
     */
    static int callingGuestInPartyProblem(int n) {
        if (n <= 1) return 1;

        int waysSingle = callingGuestInPartyProblem(n - 1);
        //for a pair, suppose we have to choose for 1 person, no. of possible choices left (n-1) and then,
        // for remaining (n-2) another call, so total no. of possibilities will be the multiplication of them
        int waysPair = (n - 1) * callingGuestInPartyProblem(n - 2);

        return waysSingle + waysPair;
    }
}