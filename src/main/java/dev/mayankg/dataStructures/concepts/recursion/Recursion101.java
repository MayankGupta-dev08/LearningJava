package dev.mayankg.dataStructures.concepts.recursion;

import dev.mayankg.dataStructures.util.Pair;

import java.util.HashSet;

class Recursion101 {
    // O(n)
    static String fibonacciSequenceForNTerms(int n) {
        StringBuilder sb = new StringBuilder("0 1");    //we know 1st two terms are 0 and 1
        String s = fibonacciHelper(0, 1, n - 2);
        return sb.append(s).toString();
    }

    private static String fibonacciHelper(int a, int b, int n) {
        if (n == 0) return "";

        int c = a + b;
        StringBuilder sb = new StringBuilder(" ").append(c);
        String s = fibonacciHelper(b, c, n - 1);
        return sb.append(s).toString();
    }

    // O(log n)
    static int calcXPowerN(int x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;

        if (n % 2 == 0) {
            return calcXPowerN(x, n / 2) * calcXPowerN(x, n / 2);
        }

        return x * calcXPowerN(x, n / 2) * calcXPowerN(x, n / 2);
    }

    // O((2^n)-1)
    static int theTowerOfHanoiProblem(int n, String src, String hlpr, String dest) {
        int movements = 0; // Initialize movements counter

        if (n == 1) {
            System.out.printf("Transferring: disk %d from %s to %s%n", n, src, dest);
            return 1;
        }

        movements += theTowerOfHanoiProblem(n - 1, src, dest, hlpr);
        System.out.printf("Transferring: disk %d from %s to %s%n", n, src, dest);
        movements++;
        movements += theTowerOfHanoiProblem(n - 1, hlpr, src, dest);

        return movements;
    }

    // O(n)
    static String reverseString(String s) {
        if (s.length() == 1) return s;

        return reverseString(s.substring(1)) + s.charAt(0);
    }

    // O(n)
    static Pair<Integer, Integer> findFirstAndLastOccurrence
    (String str, char ch, int idx, int fIdx, int lIdx) {
        if (str.length() == idx) {
            return new Pair<>(fIdx, lIdx);
        }

        if (str.charAt(idx) == ch) {
            if (fIdx == -1) fIdx = lIdx = idx;
            else lIdx = idx;
        }
        return findFirstAndLastOccurrence(str, ch, idx + 1, fIdx, lIdx);
    }

    // O(n)
    static boolean isStrictlyIncreasingArr(int[] arr, int idx) {
        if (idx == 0) return true;

        if (arr[idx - 1] >= arr[idx]) return false;
        return isStrictlyIncreasingArr(arr, idx - 1);
    }

    // O(n)
    static String moveAllOccurrenceOfACharAtEnd
    (String str, char c, int idx, int count, String ans) {
        if (idx == str.length()) {
            while (count != 0) {
                ans += c;
                count--;
            }
            return ans;
        }

        if (str.charAt(idx) == c) count++;
        else ans += str.charAt(idx);
        return moveAllOccurrenceOfACharAtEnd(str, c, idx + 1, count, ans);
    }

    // O(n)
    static String removeDuplicatesFromString(String str, int idx, boolean[] alphas, String ans) {
        if (idx == str.length()) return ans;

        char ch = str.charAt(idx);
        if (!alphas[ch - 'a']) {
            ans += ch;
            alphas[ch - 'a'] = true;
        }
        return removeDuplicatesFromString(str, idx + 1, alphas, ans);
    }

    // O(2^n), n is the length of str
    static int printAllSubsequenceOfString(String str, int idx, String ss) {
        int counter = 0;

        if (idx == str.length()) {
            System.out.println(ss);
            return 1;
        }

        char c = str.charAt(idx);
        counter += printAllSubsequenceOfString(str, idx + 1, ss);
        counter += printAllSubsequenceOfString(str, idx + 1, ss + c);
        return counter;
    }

    // O(2^n), n is the length of str
    static int printAllUniqueSubsequenceOfString(String str, int idx, String ss, HashSet<String> set) {
        int counter = 0;

        if (idx == str.length()) {
            if (!set.contains(ss)) {
                System.out.println(ss);
                set.add(ss);
                return 1;
            }
            return 0;
        }

        char c = str.charAt(idx);
        counter += printAllUniqueSubsequenceOfString(str, idx + 1, ss, set);
        counter += printAllUniqueSubsequenceOfString(str, idx + 1, ss + c, set);
        return counter;
    }

    // O(n*m), n: length of the string and m: no. of alphabets for a digit
    static int printAllKeypadCombinations(String nums, int idx, String ans, String[] keypadArr) {
        int counter = 0;
        if (nums.length() == idx) {
            System.out.println(ans);
            return 1;
        }

        char numChar = nums.charAt(idx);
        String s = keypadArr[numChar - '0'];
        for (int i = 0; i < s.length(); i++)
            counter += printAllKeypadCombinations(nums, idx + 1, ans + s.charAt(i), keypadArr);

        return counter;
    }
}