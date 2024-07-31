package dev.mayankg.ds_algo_patterns.techniques.pointers.threepointers;

/**
 * Dutch National Flag (DNF) Problem <br>
 * Given an array containing 0s, 1s, and 2s, sort the array in-place such that all 0s come before 1s and all 1s come before 2s. <br>
 * Time Complexity: O(n) <br>
 * Space Complexity: O(1) <br>
 * Similar Problems: <br>
 * - Sort Colors (LeetCode) <br>
 */
public class DNFProblem {

    /**
     * Sorts the array containing 0s, 1s, and 2s in-place such that all 0s come before 1s and all 1s come before 2s. <br>
     * Partition the array into three parts: Ultimately, the low will point to the end of 0s (first 1), and high will point to the start of 2s (last 1).
     *
     * @param arr the array to be sorted
     */
    public static void sort(int[] arr) {
        int low = 0, high = arr.length - 1;
        int i = low;
        while (i <= high) {
            if (arr[i] == 0) {
                swap(arr, i, low);
                low++;
                i++;
            } else if (arr[i] == 2) {
                swap(arr, i, high);
                high--;
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int high) {
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
    }

    static void printArray(int arr[], int n) {
        int i;
        for (i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    /*Driver function to check for above functions*/
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int n = arr.length;
        sort(arr);
        printArray(arr, n);
    }
}
