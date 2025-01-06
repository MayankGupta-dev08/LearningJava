package dev.mayankg.ds_algo_patterns.techniques.slidingwindow;

/**
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest subarray having all 1s.
 */
public class LongestSubarrayWith1sAfterReplacement {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        int k = 2;
        System.out.println(findLengthOfLongestSubarray(arr, k));    // 6
    }

    // Time Complexity : O(N)
    private static int findLengthOfLongestSubarray(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;

        int windowStart = 0;
        int maxLen = 0;
        int numberOf0s = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 0) numberOf0s++;

            while (numberOf0s > k) {    // shrinking invalid window until it becomes valid again
                if (arr[windowStart++] == 0)
                    numberOf0s--;
            }

            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }

        return maxLen;
    }
}
