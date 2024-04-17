package dev.mayankg.unitTesting.junit5.basicTests;

class ComputeUtil {
    public static <T extends Comparable<T>> T max(T first, T second) {
        return (first.compareTo(second) < 0) ? second : first;
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public double computeCircleArea(double radius) {
        return Math.PI * radius * radius;
    }
}