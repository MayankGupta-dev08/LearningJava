package dev.mayankg.lambdas.unit8OperatorInterfaces;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.UnaryOperator;

/**
 * The BinaryOperator<T> interface is a specialized form of BiFunction<T, T, T> for cases where both the inputs and the output types are the same.
 * The UnaryOperator<T> interface is a specialized form of Function<T, T> for cases where the input and output types are the same.
 */
public class OperatorInterfaceDemo {
    public static void main(String[] args) {
        BinaryOperator<Integer> addition = (a, b) -> a + b;
        System.out.println(addition.apply(-7, 5));

        // Both are doing exactly the same, IntBinaryOperator is better as it's specifically used to handle primitive type int
        IntBinaryOperator add = (a, b) -> a + b;
        System.out.println(add.applyAsInt(3, 5));

        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(3));

        Integer result = addition.andThen(square).apply(2, 3);
        System.out.println(result);
    }
}