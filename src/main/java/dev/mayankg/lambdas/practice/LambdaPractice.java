package dev.mayankg.lambdas.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * https://www.w3resource.com/java-exercises/lambda/index.php
 */
public class LambdaPractice {
    public static void main(String[] args) {
        System.out.println(qNA1(3, 6));
        System.out.println(qNA2("something"));
        qNA3(List.of("aBc", "DeF", "gHI", "JKl"));
        qNA4(List.of(1, 2, 4, 5, 3, 6, 8, 9, 7, 0));
        qNA5(Arrays.asList("red", "green", "blue", "black", "pink"));
        System.out.println("Avg of list of doubles: " + qNA6(Arrays.asList(3.5, 7.5, 4.3, 4.7, 5.1)));
        System.out.println("Distinct integers from the list: " + qNA7(Arrays.asList(1, 2, 3, 3, 4, 3, 2, 5, 6, 1, 7, 7, 8, 10)));
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

    /**
     * 3. Write a Java program to implement a lambda expression to convert a list of strings to uppercase and lowercase.
     */
    private static void qNA3(List<String> listOfString) {
        listOfString.stream().map(String::toUpperCase).forEach(System.out::print);
        System.out.println();
        listOfString.stream().map(String::toLowerCase).forEach(System.out::print);
        System.out.println();
    }

    /**
     * 4. Write a Java program to implement a lambda expression to filter out even and odd numbers from a list of integers.
     */
    private static void qNA4(List<Integer> lint) {
        List<Integer> evens = lint.stream().filter(i -> i % 2 == 0).toList();
        System.out.println(evens);

        List<Integer> odds = lint.stream().filter(i -> i % 2 != 0).toList();
        System.out.println(odds);
    }

    /**
     * 5. Write a Java program to implement a lambda expression to sort a list of strings in alphabetical order.
     */
    private static void qNA5(List<String> lstr) {
        lstr.sort(String::compareToIgnoreCase);
        System.out.println(lstr);
        ;
    }

    /**
     * 6. Write a Java program to implement a lambda expression to find the average of a list of doubles.
     */
    private static double qNA6(List<Double> ldble) {
        Double sum = ldble.stream().reduce(0.0, (acc, ele) -> acc + ele);
        return sum / ldble.size();
    }

    /**
     * 7. Write a Java program to implement a lambda expression to remove duplicates from a list of integers.
     */
    private static List<Integer> qNA7(List<Integer> list) {
        List<Integer> unique_nums = new ArrayList<>();
        list.stream().distinct().forEach(unique_nums::add);
        return unique_nums;
    }

    /**
     * 8. Write a lambda expression to implement a lambda expression to calculate the factorial of a given number.
     */
    private static void qNA8(List<Integer> list) {

    }
}