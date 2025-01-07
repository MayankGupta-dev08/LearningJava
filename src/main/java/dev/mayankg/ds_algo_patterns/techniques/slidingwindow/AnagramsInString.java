package dev.mayankg.ds_algo_patterns.techniques.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string 's' and a pattern 'p', find all anagrams of the pattern in the given string.
 */
public class AnagramsInString {
    public static void main(String[] args) {
        String s = "ppqp";
        String p = "pq";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();

        if (p == null || s == null || p.length() > s.length())
            return result;

        int[] s1map = new int[26];
        int[] s2map = new int[26];


        for (int i = 0; i < p.length(); i++) {
            s1map[p.charAt(i) - 'a']++;
            s2map[s.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1map[i] == s2map[i])
                matches++;
        }

        if (matches == 26)
            result.add(0);

        for (int i = p.length(); i < s.length(); i++) { // sliding the window

            int r = s.charAt(i) - 'a'; // handling the incoming char
            s2map[r]++;
            if (s2map[r] == s1map[r])
                matches++;
            else if (s2map[r] == s1map[r] + 1)
                matches--;

            int l = s.charAt(i - p.length()) - 'a'; // handling the incoming char
            s2map[l]--;
            if (s2map[l] == s1map[l])
                matches++;
            else if (s2map[l] == s1map[l] - 1)
                matches--;

            if (matches == 26)
                result.add(i - p.length() + 1);
        }

        return result;
    }
}
