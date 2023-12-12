package dev.mayankg.lambdas.unit4ClosuresInLambdaExpressions;

import java.util.function.Consumer;

public class ClosureExample {
    public static void main(String[] args) {
        int a = 10;

        // final int b = 20;
        int b = 20;

        doProcess(a, i -> System.out.println(i + b));
    }

    /**
     * Although the variable b is not being passed in the method doProcess, it is still being accessible due to closures in Java8
     * And the variable b is considered to be effectively final in Java8 and later versions of Java, before explicitly final keyword was required for this variable.
     */
    private static void doProcess(int a, Consumer<Integer> integerConsumer) {
        integerConsumer.accept(a);
    }
}