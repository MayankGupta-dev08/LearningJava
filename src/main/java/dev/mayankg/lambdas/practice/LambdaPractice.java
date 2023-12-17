package dev.mayankg.lambdas.practice;

import java.util.function.BiFunction;
import java.util.function.Predicate;

/**https://www.w3resource.com/java-exercises/lambda/index.php*/
public class LambdaPractice {
    public static void main(String[] args) {
        int ans1 = qNA1(3, 6);
        System.out.println(ans1);

        boolean s = qNA2("something");
        System.out.println(s);
    }

    /**
     * 1. Write a Java program to implement a lambda expression to find the sum of two integers.
     */
    private static int qNA1(int a, int b) {
//        BiFunction<Integer, Integer, Integer> sumOfTwoInteger = (n1, n2) -> { return n1 + n2; };
        BiFunction<Integer, Integer, Integer> sumOfTwoInteger = Integer::sum;
        return sumOfTwoInteger.apply(a, b);
    }

    /**
     * 2. Write a Java program to implement a lambda expression to check if a given string is empty.
     */
    private static boolean qNA2(String s) {
//        Predicate<String> isEmptyString = str -> str.isEmpty();
        Predicate<String> isEmptyString = String::isEmpty;
        return isEmptyString.test(s);
    }
}