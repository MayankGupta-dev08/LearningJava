package dev.mayankg.streams;

import dev.mayankg.streams.Util.Movie;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
        boolean isAnyHitMovie =
                movies.stream()
                        .map(Movie::getRating)
                        .anyMatch(r -> r > 9.5);
        System.out.println(isAnyHitMovie);
    }

    /**
     * ALLMATCH IN STREAMS
     */
    void allMatchInStream() {
        System.out.println("-->get true only when all the elements satisfy the condition<--");
        boolean areAllMoviesGood =
                movies.stream()
                        .map(Movie::getRating)
                        .allMatch(r -> r > 7.5);
        System.out.println(areAllMoviesGood);
    }

    /**
     * FINDFIRST IN STREAMS
     */
    void findFirstInStream() {
        System.out.println("-->get the first element from incoming stream<--");
        Optional<Movie> optionalOfMovie =
                movies.stream()
                        .findFirst();
        Movie movie = optionalOfMovie.get();
        System.out.println(movie);
    }

    /**
     * FINDANY IN STREAMS
     */
    void findAnyInStream() {
        System.out.println("-->get any element from the incoming stream<--");
        Optional<Movie> optionalOfMovie =
                movies.stream()
                        .findAny();
        Movie movie = optionalOfMovie.get();
        System.out.println(movie);
    }

    /**
     * GET MAX IN STREAMS
     */
    void findMaxInStream() {
        System.out.println("-->get max element from the incoming stream<--");
        Optional<Movie> optionalOfMovie =
                movies.stream()
                        .max(Comparator.comparing(Movie::getRating));
        Movie movie = optionalOfMovie.get();
        System.out.println("Movie with max rating " + movie);
    }

    /**
     * GET MIN IN STREAMS
     */
    void findMinInStream() {
        System.out.println("-->get min element from the incoming stream<--");
        Optional<Movie> optionalOfMovie =
                movies.stream()
                        .min(Comparator.comparing(Movie::getRating));
        Movie movie = optionalOfMovie.get();
        System.out.println("Movie with min rating " + movie);
    }
}