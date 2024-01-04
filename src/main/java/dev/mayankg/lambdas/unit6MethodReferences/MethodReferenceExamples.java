package dev.mayankg.lambdas.unit6MethodReferences;

import java.util.function.BiFunction;

public class MethodReferenceExamples {
    public static void main(String[] args) {
        Thread t1 = new Thread(MethodReferenceExamples::printMessage); // () -> method() === ClassName::methodName
        t1.start();

        int sum = compute(10, 20, MethodReferenceExamples::printSum); // (a, b) -> printSum(a, b)
        System.out.println(sum);
    }

    static void printMessage() {
        System.out.println("Hello");
    }

    static int printSum(int a, int b) {
        return a + b;
    }

    static int compute(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }
}