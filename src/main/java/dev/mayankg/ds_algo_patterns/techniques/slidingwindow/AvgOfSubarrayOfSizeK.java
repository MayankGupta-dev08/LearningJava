package dev.mayankg.ds_algo_patterns.techniques.slidingwindow;

import java.util.Arrays;

/**
 * Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 */
public class AvgOfSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 5;
        System.out.println(Arrays.toString(findAvgOfSubArray(arr, k)));
    }

    private static double[] findAvgOfSubArray(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k > arr.length)
            return new double[0];

        double[] result = new double[arr.length - k + 1];
        double windowSum = 0;

        for (int i = 0; i < k; i++)
            windowSum += arr[i];

        result[0] = windowSum / k;

        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            result[i - k + 1] = windowSum / k;
        }

        return result;
    }

    private static double findMaxAvgOfSubarrayOfSizeK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || nums.length < k)
            return 0;

        double windowSum = 0;
        for (int i = 0; i < k; i++)
            windowSum += nums[i];

        double maxSum = windowSum;
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum / k;
    }
}