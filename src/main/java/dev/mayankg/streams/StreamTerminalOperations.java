package dev.mayankg.streams;

import dev.mayankg.streams.Util.Movie;

import java.util.List;
import java.util.stream.Stream;

class StreamTerminalOperations {
    private final List<Movie> movies;

    public StreamTerminalOperations() {
        StreamsDemo sd = new StreamsDemo();
        this.movies = sd.getMovies();
    }

    /**
     * COUNT THE ELEMENTS
     */
    void countInStream() {
        System.out.println("-->get the count of elements<--");
        long numsDivisibleBy11 = Stream.of(11, 22, 33, 11, 55, 44, 22, 88, 66, 77, 99)
                .distinct()
                .filter(x -> x % 11 == 0)
                .count();
        System.out.println(numsDivisibleBy11);
    }

    /**
     * ANYMATCH IN STREAMS
     */
    void anyMatchInStream() {
        System.out.println("-->get true if any of the element satisfy the condition<--");
        boolean isAnyHitMovie = movies.stream()
                .map(m -> m.getRating())
                .anyMatch(r -> r > 9.5);
        System.out.println(isAnyHitMovie);
    }

    /**
     * ALLMATCH IN STREAMS
     */
    void allMatchInStream() {
        System.out.println("-->get true only when all the elements satisfy the condition<--");
        boolean areAllMoviesGood = movies.stream()
                .map(m -> m.getRating())
                .anyMatch(r -> r > 7.5);
        System.out.println(areAllMoviesGood);
    }
}