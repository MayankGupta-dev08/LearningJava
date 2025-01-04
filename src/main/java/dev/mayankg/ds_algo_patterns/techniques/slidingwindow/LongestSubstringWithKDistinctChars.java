package dev.mayankg.ds_algo_patterns.techniques.slidingwindow;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 */
public class LongestSubstringWithKDistinctChars {
    public static void main(String[] args) {
        String str = "araaci";
        int k = 2;
        System.out.println(findLengthOfLongestSubstringWithKDistinctChars(str, k));

        str = "cbbebi";
        k=3;
        System.out.println(findLengthOfLongestSubstringWithKDistinctChars(str, k));
    }

    private static int findLengthOfLongestSubstringWithKDistinctChars(String str, int k) {
        if (str == null || str.isEmpty() || k <= 0)
            return 0;

        int maxLen = 0;
        int windowStart = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            Character rightChar = str.charAt(windowEnd);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while (map.size() > k) {
                Character leftChar = str.charAt(windowStart);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0)
                    map.remove(leftChar);
                windowStart++;
            }

            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }

        return maxLen;
    }
}