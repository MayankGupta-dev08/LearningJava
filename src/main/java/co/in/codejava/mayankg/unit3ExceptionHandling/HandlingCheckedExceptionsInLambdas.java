/**
 * This time we are trying to write into a file instead of printing out on the screen.
 * So in this scenario we have to deal with a checked exception (IOException) which must be handled explicitly.
 */
package co.in.codejava.mayankg.unit3ExceptionHandling;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class HandlingCheckedExceptionsInLambdas {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
        //approach1: verbose and cumbersome
        processNumbers_m1(integers, i -> {
            try {
                writeToFile(i);
            } catch (IOException e) {
                System.err.println("IOException occurred: " + e.getMessage());
                throw new RuntimeException(e);
            }
        });
        //approach2: better
        processNumbers_m2(integers, i -> writeToFile(i));
        //approach3: best
        integers.forEach(handlingConsumerWrapper(i -> writeToFile(i), IOException.class));
    }


    /**
     * In our case, writeToFile method is the implementation of Consumer<Integer> functional interface.
     * As we know that the accept method of the Consumer interface doesn't declare any checked exception.
     * This is why writeToFile isn't allowed to throw the IOException.
     * The most straightforward way would be to use a try-catch block, wrap the checked exception into an unchecked exception and rethrow it.
     * As done above in the main method for approach1.
     */
    private static void processNumbers_m1(List<Integer> integers, Consumer<Integer> consumer) {
        integers.forEach(i -> consumer.accept(i));
    }

    private static void processNumbers_m2(List<Integer> integers, ThrowingConsumer<Integer, Exception> throwingConsumer) {
        integers.forEach(throwingConsumerWrapper(throwingConsumer));
    }

    /**
     * In this approach we have created a custom functional Interface which is ThrowingConsumer with a single abstract method accept which throws an exception.
     * Then we have a wrapper method that's able to rethrow the exception. This is still a workaround but a better version.
     * Both, the ThrowingConsumer interface and the throwingConsumerWrapper method are generic and can be easily reused in different places of our application.
     */
    private static <T> Consumer<T> throwingConsumerWrapper(ThrowingConsumer<T, Exception> throwingConsumer) {
        return i -> {
            try {
                throwingConsumer.accept(i);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }


    /**
     * Since our ThrowingConsumer interface uses generics, we can easily handle any specific exception.
     */
    private static <T, E extends Exception> Consumer<T> handlingConsumerWrapper(ThrowingConsumer<T, E> throwingConsumer, Class<E> exceptionClass) {
        return i -> {
            try {
                throwingConsumer.accept(i);
            } catch (Exception ex) {
                try {
                    E exCast = exceptionClass.cast(ex);
                    System.err.println("Exception occured : " + exCast.getMessage());
                } catch (ClassCastException ccEx) {
                    throw new RuntimeException(ex);
                }
            }
        };
    }

    private static void writeToFile(Integer integer) throws IOException {
        // logic to write to file which throws IOException
    }

}

@FunctionalInterface
interface ThrowingConsumer<T, E extends Exception> {
    void accept(T t) throws E;
}
