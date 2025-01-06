package dev.mayankg.ds_algo_patterns.techniques.slidingwindow;

/**
 * Given two strings s1 and s2, return true if s2 contains the permutation of s1.
 * In other words, one of s1's permutations is the substring of s2.
 */
public class PermutationInAString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));    // true

        s1 = "ab";
        s2 = "eidboaoo";
        System.out.println(checkInclusion(s1, s2));    // false
    }

    private static boolean checkInclusion(String s1, String s2) {
        if ((s1 == null && s2 != null) || (s1 != null && s2 == null)
                || s1.length() > s2.length()) return false;

        int[] s1map = new int[26];
        int[] s2map = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++)
            if (s1map[i] == s2map[i]) matches++;

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++, l++) {
            if (matches == 26) return true; //anagramic substring found in s2

            int i = s2.charAt(r) - 'a';
            s2map[i]++;
            if (s2map[i] == s1map[i]) matches++;
            else if (s2map[i] == s1map[i] + 1) matches--;

            int j = s2.charAt(l) - 'a';
            s2map[j]--;
            if (s2map[j] == s1map[j]) matches++;
            else if (s2map[i] == s1map[i] - 1) matches--;
        }
        return matches == 26;
    }
}