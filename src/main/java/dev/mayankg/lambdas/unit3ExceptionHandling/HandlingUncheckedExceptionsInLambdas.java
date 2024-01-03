package dev.mayankg.lambdas.unit3ExceptionHandling;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Unchecked Exceptions:
 * Unchecked exceptions are like unexpected situations during your journey that you couldn't have anticipated.
 * These are unforeseen events that are beyond your control.
 * For example, NullPointerException or ArrayIndexOutOfBoundsException, ArithmeticException, ClassCastException,
 * often indicate unexpected and critical errors during program execution.
 */
public class HandlingUncheckedExceptionsInLambdas {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
        Consumer<Integer> intConsumer = i -> System.out.println(50 / i);

        // general approach
        generalApproach(integers, intConsumer);

        //approach1
        processNumbers_m1(integers, intConsumer);

        //approach2
        processNumbers_m2(integers, intConsumer);
    }

    /**
     * This is not the ideal approach as we don't know what kind of consumer is coming, hence we won't be able to cover all the scenarios using few catch blocks.
     */
    private static void generalApproach(List<Integer> integers, Consumer<Integer> consumer) {
        try {
            integers.forEach(consumer);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception occurred: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Runtime Exception occurred: " + e.getMessage());
        }
    }

    private static void processNumbers_m1(List<Integer> integers, Consumer<Integer> consumer) {
        integers.forEach(lambdaWrapper(consumer));
    }

    /**
     * The use of try-catch solves the problem, but the conciseness of a Lambda Expression is lost, and it's no longer a small function as it's supposed to be.
     * To deal with this problem, we can write a lambda wrapper for the lambda function.
     */
    static Consumer<Integer> lambdaWrapper(Consumer<Integer> consumer) {
        return i -> {
            try {
                consumer.accept(i);
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic Exception occurred: " + e.getMessage());
            } catch (RuntimeException e) {
                System.err.println("Runtime Exception occurred: " + e.getMessage());
            }
        };
    }

    private static void processNumbers_m2(List<Integer> integers, Consumer<Integer> integerConsumer) {
        integers.forEach(consumerWrapper(integerConsumer, ArithmeticException.class));
    }

    /**
     * The wrapper method works as expected, but you may argue that it's basically removing the try-catch block from lambda expression and moving it to another method, so it doesn't reduce the actual number of lines of code being written.
     * This is true in this case where the wrapper is specific to a particular use case, but we can make use of generics to improve this method and use it for a variety of other scenarios
     */
    static <T, E extends Exception> Consumer<T> consumerWrapper(Consumer<T> consumer, Class<E> clazz) {
        return i -> {
            try {
                consumer.accept(i);
            } catch (Exception ex) {
                try {
                    E eClass = clazz.cast(ex);
                    System.out.println("Exception occurred: " + eClass.getMessage());
                } catch (ClassCastException ccEx) {
                    System.err.println("ClassCast Exception occurred!!" + ccEx.getMessage());
                }
            }
        };
    }
}