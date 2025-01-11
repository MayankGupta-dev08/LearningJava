package dev.mayankg.ds_algo_patterns.techniques.pointers.twopointers;

import java.util.Arrays;

class ThreeSumSmaller {
    // Test cases
    public static void main(String[] args) {
        ThreeSumSmaller solution = new ThreeSumSmaller();

        // Test Case 1
        int[] nums1 = {-2, 0, 1, 3};
        int target1 = 2;
        System.out.println("Test 1: " + solution.threeSumSmaller(nums1, target1));  // Expected: 2

        // Test Case 2
        int[] nums2 = {1, 1, -2};
        int target2 = 1;
        System.out.println("Test 2: " + solution.threeSumSmaller(nums2, target2));  // Expected: 1
    }

    /**
     * Finds the count of triplets where sum is less than target
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     */
    public int threeSumSmaller(int[] nums, int target) {
        // Edge cases
        if (nums == null || nums.length < 3) {
            return 0;
        }

        // Sort array to use two pointers approach
        Arrays.sort(nums);
        int count = 0;

        // Fix the first element and use two pointers for the rest
        for (int i = 0; i < nums.length - 2; i++) {
            count += findPairs(nums, i + 1, target - nums[i]);
        }

        return count;
    }

    /**
     * Helper method to find pairs using two pointers
     * Returns count of valid pairs for current first element
     */
    private int findPairs(int[] nums, int left, int target) {
        int right = nums.length - 1;
        int count = 0;

        while (left < right) {
            if (nums[left] + nums[right] < target) {
                // All numbers between left and right will also work
                // because array is sorted
                count += right - left;
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
