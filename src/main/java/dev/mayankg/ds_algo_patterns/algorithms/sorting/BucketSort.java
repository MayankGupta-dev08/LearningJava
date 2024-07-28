package dev.mayankg.ds_algo_patterns.algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Bucket Sort <br>
 * Time Complexity: O(n log(n)) <br>
 * Space Complexity: O(N), N = number of buckets <br>
 * Stable: Yes <br>
 * In-Place: No <br>
 * We should avoid using Bucket sort if the input is not uniformly distributed, or we have space concern. <br>
 */
@SuppressWarnings({"unused"})
public final class BucketSort {

    /**
     * Bucket sort is a sorting algorithm that works by distributing the elements of an array into a number of buckets.
     * <p>
     * 1. Number of Buckets = ceil(sqrt(n)), where n=arr.length <br>
     * 2. Find the max value of the array & create and initialize an array of buckets. <br>
     * 3.For each value, find the bucketIndex = ceil((value * numberOfBuckets) / (maxValue + 1)) and add the value to the bucket.  <br>
     * 4. Sort each bucket individually using any sorting algorithm.  <br>
     * 5. Replace the values in the original array by iterating over the buckets.
     *
     * @param arr the array to be sorted
     */
    public static void sort(int[] arr) {
        int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        int maxValue = Integer.MIN_VALUE;
        for (int value : arr)
            maxValue = Math.max(maxValue, value);

        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
        for (int i = 0; i < numberOfBuckets; i++)
            buckets[i] = new ArrayList<>();

        for (int value : arr) {
            int bucketIndex = (int) Math.ceil((value * numberOfBuckets) / (maxValue + 1));
            buckets[bucketIndex].add(value);
        }

        System.out.println("\nPrinting Buckets before sorting...");
        printBuckets(buckets);

        for (ArrayList<Integer> bucket : buckets)
            Collections.sort(bucket);

        System.out.println("\nPrinting Buckets after sorting...");
        printBuckets(buckets);

        int index = 0;
        for (ArrayList<Integer> bucket : buckets)
            for (int value : bucket)
                arr[index++] = value;
    }

    private static void printBuckets(ArrayList<Integer>[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            System.out.println("Bucket#" + i + ": " + buckets[i]);
        }
    }
}