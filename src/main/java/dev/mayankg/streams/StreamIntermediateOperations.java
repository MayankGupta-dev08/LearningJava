package dev.mayankg.streams;

import dev.mayankg.streams.Util.Movie;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamIntermediateOperations {
    private final List<Movie> movies;

    public StreamIntermediateOperations() {
        StreamsDemo sd = new StreamsDemo();
        this.movies = sd.getMovies();
    }

    /**
     * GETTING DISTINCT RESULTS IN STREAMS
     */
    void distinctInStream() {
        System.out.println("-->Getting distinct results<--");
        Stream.of(11, 22, 33, 11, 55, 44, 22, 88, 66, 77, 99)
                .distinct()
                .forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    /**
     * SORTING IN STREAMS
     */
    void sortingInStream() {
        System.out.println("-->Movies sorted by name<--");
        List<Movie> moviesSortedByName = movies.stream().sorted().collect(Collectors.toList());
        System.out.println(moviesSortedByName);

        System.out.println("-->Movies sorted by rating (hi to low)<--");
        List<Movie> moviesSortedByRating =
                // movies.stream().sorted(new MovieRatingComparator()).collect(Collectors.toList());
                movies.stream()
                        .sorted(Comparator.comparing(Movie::getRating).reversed())
                        .collect(Collectors.toList());
        System.out.println(moviesSortedByRating);
    }

    /**
     * SLICING IN STREAMS
     */
    void slicingInStream() {
        // The takeWhile operation will take elements from the stream until the first non-conforming element is encountered (won't check till the end)
        System.out.printf("%n--->Result from takeWhile()<---%n");
        movies.stream().takeWhile(m -> m.getRating() >= 7.0f).forEach(System.out::println);

        // The dropWhile operation will drop elements from the stream until the first non-conforming element is encountered.
        // The result will be a stream containing only the remaining elements after dropping those that satisfy the condition.
        System.out.printf("--->Result from dropWhile()<---%n");
        movies.stream().dropWhile(m -> m.getRating() >= 7.0f).forEach(System.out::println);
    }

    /**
     * PAGINATION USING STREAMS
     */
    void paginationInStream() {
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
                .forEach(x -> System.out.print(x + " "));
    }

    /**
     * PEEKING IN STREAMS: FOR DEBUGGING/CHECKING INTERMEDIATE RESULTS
     */
    void peekingInStreams() {
        System.out.printf("--->Peeking in stream api<---%n");
        List<String> res = movies.stream()
                .filter(m -> m.getRating() >= 7.0f)
                .peek(m -> System.out.printf("Filtered: {%s:%s}%n", m.getName(), m.getRating()))
                .map(Movie::getName)
                .peek(m -> System.out.println("Mapped: " + m))
                .toList();
        System.out.println(res);
    }
}