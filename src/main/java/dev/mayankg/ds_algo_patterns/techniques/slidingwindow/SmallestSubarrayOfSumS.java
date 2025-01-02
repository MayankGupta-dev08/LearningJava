package dev.mayankg.ds_algo_patterns.techniques.slidingwindow;

/**
 * Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
 */
public class SmallestSubarrayOfSumS {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 2, 3, 2};
        int s = 7;
        System.out.println(findSmallestSubArray(arr, s));
    }

    private static int findSmallestSubArray(int[] arr, int S) {
        if (arr == null || arr.length == 0)
            return 0;

        int windowSum = 0;
        int windowStart = 0;
        int minWindowSize = Integer.MAX_VALUE;

        // windowStart is the left pointer, i is the right pointer
        for (int i = 0; i < arr.length; i++) {
            // Optimization: if any single element is >= S, we can return 1
            if (arr[i] >= S)
                return 1;

            // Add the current element to our window
            windowSum += arr[i];

            // Shrink window as long as sum >= S
            while (windowSum >= S) {
                minWindowSize = Math.min(minWindowSize, i - windowStart + 1);
                // Remove elements from the start of window
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return minWindowSize == Integer.MAX_VALUE ? 0 : minWindowSize;
    }
}