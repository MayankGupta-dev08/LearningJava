package dev.mayankg.ds_algo_patterns.techniques.slidingwindow;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
 * find the length of the longest substring having the same letters after replacement.
 */
public class LongestRepeatingLetterSubstringAfterReplacement {
    public static void main(String[] args) {
        String str = "AABCCBB"; // Output: 5
        int k = 2;
        System.out.println(findLengthOfLongestSubstring(str, k));

        str = "ABBCB";  // Output: 5
        k = 1;
        System.out.println(findLengthOfLongestSubstring(str, k));

        str = "ABCCDE"; // Output: 3
        k = 1;
        System.out.println(findLengthOfLongestSubstring(str, k));

        str = "AABABBA"; // Output: 5
        k = 2;
        System.out.println(findLengthOfLongestSubstring(str, k));
    }

    // Time Complexity: O(N)
    private static int findLengthOfLongestSubstring(String str, int k) {
        if (str == null || str.isEmpty() || k < 0)
            return 0;

        int maxLen = 0;
        int windowStart = 0;
        int mostFreqChar = 0;  // Count of most frequent char in current window
        int[] freqArr = new int[26];

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            // Add new character to window
            freqArr[str.charAt(windowEnd) - 'A']++;
            mostFreqChar = Math.max(mostFreqChar, freqArr[str.charAt(windowEnd) - 'A']);

            int lettersToBeReplaced = (windowEnd - windowStart + 1) - mostFreqChar;

            // If replacements needed > k, shrink window
            if (lettersToBeReplaced > k) {
                freqArr[str.charAt(windowStart) - 'A']--;
                windowStart++;
            }

            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }

        return maxLen;
    }
}