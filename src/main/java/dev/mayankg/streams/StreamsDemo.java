package dev.mayankg.streams;

import dev.mayankg.streams.Util.Genre;
import dev.mayankg.streams.Util.Movie;

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
class StreamsDemo {
    private final List<Movie> movies;

    StreamsDemo() {
        this.movies = List.of(
                new Movie("c", 8.0f, Genre.ACTION),
                new Movie("a", 4.5f, Genre.COMEDY),
                new Movie("d", 7.5f, Genre.THRILLER),
                new Movie("b", 5.3f, Genre.ACTION)
        );
    }

    public static void main(String[] args) {
        differentWaysOfCreatingStream();
        intermediateOperationsDemo();
        terminalOperationsDemo();
        collectorOperationsDemo();
    }

    private static void intermediateOperationsDemo() {
        StreamIntermediateOperations iSO = new StreamIntermediateOperations();
        iSO.paginationInStream();
        iSO.slicingInStream();
        iSO.sortingInStream();
        iSO.distinctInStream();
        iSO.peekingInStreams();
    }

    private static void terminalOperationsDemo() {
        StreamTerminalOperations tSO = new StreamTerminalOperations();
        tSO.countInStream();
        tSO.anyMatchInStream();
        tSO.allMatchInStream();
        tSO.noneMatchInStream();
        tSO.findFirstInStream();
        tSO.findAnyInStream();
        tSO.findMaxInStream();
        tSO.findMinInStream();
        tSO.reduceInStreams();
    }

    private static void collectorOperationsDemo() {
        StreamOtherOperations scm = new StreamOtherOperations();
        scm.collectInStreams();
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

        //Using a primitive stream type
        IntStream.rangeClosed(1, 10).forEachOrdered(x -> System.out.print(x + " "));
        System.out.println();
    }

    List<Movie> getMovies() {
        return movies;
    }
}