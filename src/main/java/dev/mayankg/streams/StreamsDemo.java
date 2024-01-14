package dev.mayankg.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Intermediate Operations in Stream: peek(), filter(), map(), flatMap(), limit(), skip(), sorted(), distinct(), takeWhile(), dropWhile()
 * Reducing/Terminal Operations in Stream: count(), collect(), reduce(), forEach(), min(), max(), findFirst(), findAny(), anyMatch(), allMatch(), noneMatch()
 */
public class StreamsDemo {

    public static void main(String[] args) {
        differentWaysOfCreatingStream();

        StreamIntermediateOperations iSO = new StreamIntermediateOperations();
        iSO.paginationInStream();
        iSO.slicingInStream();
        iSO.sortingInStream();
        iSO.distinctInStream();
        iSO.peekingInStreams();

        StreamTerminalOperations tSO = new StreamTerminalOperations();
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