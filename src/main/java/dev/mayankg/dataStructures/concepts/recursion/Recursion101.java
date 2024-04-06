package dev.mayankg.dataStructures.concepts.recursion;

class Recursion101 {
    public static void main(String[] args) {

    }

    static int calcXPowerN(int x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;

        if (n % 2 == 0)
            return calcXPowerN(x, n / 2) * calcXPowerN(x, n / 2);

        return x * calcXPowerN(x, n / 2) * calcXPowerN(x, n / 2);
    }

    static void fibonacciSequenceForNTerms(int n) {
        System.out.print("Fibonacci for " + n + " terms: ");
        System.out.print("0 1");    //we know 1st two terms are 0 and 1
        fibonacciHelper(0, 1, n - 2);
        System.out.println();
    }

    private static void fibonacciHelper(int a, int b, int n) {
        if (n == 0) return;

        int c = a + b;
        System.out.print(" " + c);
        fibonacciHelper(b, c, n - 1);
    }
}