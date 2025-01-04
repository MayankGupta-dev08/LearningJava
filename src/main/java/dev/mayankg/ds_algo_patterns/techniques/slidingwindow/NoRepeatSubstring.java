package dev.mayankg.ds_algo_patterns.techniques.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring with no repeating characters.
 */
public class NoRepeatSubstring {
    public static void main(String[] args) {
        String str = "aabccbb";
        System.out.println(findLengthOfLongestSubstring(str));

        str = "abbbb";
        System.out.println(findLengthOfLongestSubstring(str));

        str = "abccde";
        System.out.println(findLengthOfLongestSubstringOptimized(str));

        str = "abcdeabc";
        System.out.println(findLengthOfLongestSubstringOptimized(str));
    }

    // Time Complexity: O(N)
    private static int findLengthOfLongestSubstring(String str) {
        if (str == null || str.isEmpty())
            return 0;

        int maxLen = 0;
        int windowStart = 0;
        Set<Character> set = new HashSet<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            while (set.contains(rightChar)) {
                char leftChar = str.charAt(windowStart);
                set.remove(leftChar);
                windowStart++;
            }

            set.add(rightChar);
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen;
    }

    // Time Complexity: O(N)
    private static int findLengthOfLongestSubstringOptimized(String str) {
        if (str == null || str.isEmpty())
            return 0;

        int maxLen = 0;
        int windowStart = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            if (map.containsKey(rightChar))
                windowStart = Math.max(windowStart, map.get(rightChar) + 1);

            map.put(rightChar, windowEnd);
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen;
    }
}
