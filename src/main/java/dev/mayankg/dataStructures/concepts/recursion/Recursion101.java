package dev.mayankg.dataStructures.concepts.recursion;

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
}