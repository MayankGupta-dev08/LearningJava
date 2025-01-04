package dev.mayankg.ds_algo_patterns.techniques.slidingwindow;

import java.util.HashMap;

/**
 * Given an array of characters where each character represents a fruit tree, you are given two baskets, and your goal is to put maximum number of fruits in each basket.
 * The only restriction is that each basket can have only one type of fruit.
 * You can start with any tree, but you can’t skip a tree once you have started.
 * What is the maximum number of fruits you can collect?
 */
public class FruitsIntoBaskets {
    public static void main(String[] args) {
        char[] arr = {'A', 'B', 'C', 'A', 'C'};
        System.out.println(findLengthOfLongestSubArray(arr));
    }

    /** Longest Substring with 2 Distinct Characters */
    private static int findLengthOfLongestSubArray(char[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int maxLen = 0;
        int windowStart = 0;
        int maxFruits = 2;
        HashMap<Character, Integer> fruitFrequency = new HashMap<>();

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char fruit = arr[windowEnd];
            fruitFrequency.put(fruit, fruitFrequency.getOrDefault(fruit, 0) + 1);

            while (fruitFrequency.size() > maxFruits) {
                char aFruit = arr[windowStart];
                fruitFrequency.put(aFruit, fruitFrequency.get(aFruit) - 1);
                if (fruitFrequency.get(aFruit) == 0)
                    fruitFrequency.remove(aFruit);
                windowStart++;
            }

            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }

        return maxLen;
    }
}
