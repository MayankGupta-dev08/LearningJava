package co.in.codejava.mayankg.unit3ExceptionHandling;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class HandlingUncheckedExceptionsInLambdas {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
        //approach1
        processNumbers_m1(integers, i -> System.out.println(50 / i));
        //approach2
        processNumbers_m2(integers, i -> System.out.println(50 / i));
    }

    private static void processNumbers_m1(List<Integer> integers, Consumer<Integer> consumer) {
        integers.forEach(lambdaWrapper(consumer));
    }

    /**
     * The use of try-catch solves the problem, but the conciseness of a Lambda Expression is lost, and it's no longer a small function as it's supposed to be.
     * To deal with this problem, we can write a lambda wrapper for the lambda function.
     */
    private static Consumer<Integer> lambdaWrapper(Consumer<Integer> consumer) {
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
        integers.forEach(throwingConsumer(integerConsumer, ArithmeticException.class));
    }

    /**
     * The wrapper method works as expected but, you may argue that it's basically removing the try-catch block from lambda expression and moving it to another method, and it doesn't reduce the actual number of lines of code being written.
     * This is true in this case where the wrapper is specific to a particular use case but we can make use of generics to improve this method and use it for a variety of other scenarios
     */
    static <T, E extends Exception> Consumer<T> throwingConsumer(Consumer<T> consumer, Class<E> clazz) {
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
