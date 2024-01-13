package dev.mayankg.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) {
        /* Suppose we are getting the response after making a http request and the result has 50 elements */
        Stream<Integer> resultStream = Stream.iterate(1, n -> n + 1).limit(50);
        /*
         Now we want to display the response of the request in paginated format, where:
         - pageSize=10, and we want to see the 3rd page
         - Now for the 3rd page (page=3) we need to
            - skip(20) = skip( (page-1) * pageSize )
            - limit(10) = limit(pageSize)
        */
        int pageSize = 10, page = 3;
        resultStream
                .skip((page - 1) * pageSize)
                .limit(pageSize)
                .forEach(System.out::println);
    }

    private static void differentWaysOfCreatingStream() {
        // 1st way
        ArrayList<Integer> nList = new ArrayList<>(List.of(1, 2, 3, 7, 8));
        Stream<Integer> stream1 = nList.stream();

        // 2nd way
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        IntStream stream2 = Arrays.stream(numbers);

        // 3rd way
        Stream<Integer> stream3 = Stream.of(1, 2, 4, 5, 6);

        // 4th way
        Stream<Set<Integer>> stream4 = Stream.ofNullable(Set.of(1, 3, 5, 7, 9));

        // 5th way
        Stream<Double> stream5 = Stream.generate(Math::random).limit(5);

        // 6th way
        Stream<Integer> stream6 = Stream.iterate(0, n -> n++).limit(10);
    }
}