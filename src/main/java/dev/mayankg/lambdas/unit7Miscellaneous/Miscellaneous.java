package dev.mayankg.lambdas.unit7Miscellaneous;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Miscellaneous {
    public static void main(String[] args) {
        // Define an array of Runnable (or any functional interface)
        Runnable[] methodsToCall = {
                Miscellaneous::combiningConsumersInLambdas,
                Miscellaneous::composingFunctionsInLambdas,
                Miscellaneous::combiningPredicatesInLambdas
        };

        // Iterate through the array and invoke each method
        for (Runnable method : methodsToCall) {
            method.run();
        }
    }

    private static void combiningConsumersInLambdas() {
        Consumer<String> printThis = System.out::print;
        Consumer<String> printUpperCase = x -> System.out.println(" " + x.toUpperCase());
        IntStream.range(97, 123).forEach(i -> {
            char x = (char) i;
            printThis.andThen(printUpperCase).accept(Character.toString(x));
        });
    }

    private static void composingFunctionsInLambdas() {
        // Suppose we are getting a String in the form of "key:value"
        // After the 1st transformation --> "key=value"
        // After the 2nd transformation --> "{key=value}"
        String input = "Key:Value";
        Function<String, String> replaceColonWithEqual = str -> str.replace(':', '=');
        Function<String, String> addBraces = str -> "{" + str + "}";
        String output = replaceColonWithEqual.andThen(addBraces).apply(input);
        System.out.println(output);

        // compose() does the same work as andThen() but we have to write in reverse order
        String res = addBraces.compose(replaceColonWithEqual).apply(input);
        System.out.println(res);
    }

    private static void combiningPredicatesInLambdas() {
        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.endsWith("}");

        String x = "{key:value";
        boolean hasLeftANDRightBraces = hasLeftBrace.and(hasRightBrace).test(x);
        System.out.println(hasLeftANDRightBraces);
        boolean hasLeftORRightBraces = hasLeftBrace.or(hasRightBrace).test(x);
        System.out.println(hasLeftORRightBraces);
        boolean doesNotHaveRightBrace = hasRightBrace.negate().test(x);
        System.out.println(doesNotHaveRightBrace);
    }
}