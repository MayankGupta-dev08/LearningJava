package dev.mayankg.junit5;

public class ComputeUtil {

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        return a / b;
    }

    public static double computeCircleArea(double radius) {
        return Math.PI * radius * radius;
    }
}