package dev.mayankg.streams;

import dev.mayankg.streams.Util.Movie;
import dev.mayankg.streams.Util.MovieRatingComparator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {
    private static final List<Movie> movies = List.of(
            new Movie("c", 8.0f),
            new Movie("a", 4.5f),
            new Movie("d", 7.5f),
            new Movie("b", 5.3f)
    );

    public static void main(String[] args) {
        /**PAGINATION USING STREAMS*/
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

        /**SLICING IN STREAMS*/
        // The takeWhile operation will take elements from the stream until the first non-conforming element is encountered (won't check till the end)
        System.out.printf("%n--->Result from takeWhile()<---%n");
        movies.stream().takeWhile(m -> m.getRating() >= 7.0f).forEach(System.out::println);

        // The dropWhile operation will drop elements from the stream until the first non-conforming element is encountered.
        // The result will be a stream containing only the remaining elements after dropping those that satisfy the condition.
        System.out.printf("--->Result from dropWhile()<---%n");
        movies.stream().dropWhile(m -> m.getRating() >= 7.0f).forEach(System.out::println);

        /**SORTING IN STREAMS*/
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