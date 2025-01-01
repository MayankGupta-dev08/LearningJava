package dev.mayankg.ds_algo_patterns.techniques.slidingwindow;

/**
 * Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
 */
public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(findMaxSubArraySum(arr, k));
        System.out.println(getMaxSubArraySum(arr, k));
    }

    private static int findMaxSubArraySum(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k > arr.length)
            return 0;

        int windowSum = 0;
        for (int i = 0; i < k; i++)
            windowSum += arr[i];

        int maxSum = windowSum;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    private static int getMaxSubArraySum(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k > arr.length)
            return 0;

        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];

            if (i >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[i - k + 1];
            }
        }

        return maxSum;
    }
}