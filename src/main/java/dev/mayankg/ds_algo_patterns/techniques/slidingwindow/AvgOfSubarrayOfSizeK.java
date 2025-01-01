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
}