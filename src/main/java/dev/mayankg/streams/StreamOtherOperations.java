package dev.mayankg.streams;

import dev.mayankg.streams.Util.Genre;
import dev.mayankg.streams.Util.Movie;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class StreamOtherOperations {
    private final List<Movie> movies;

    StreamOtherOperations() {
        StreamsDemo streamsDemo = new StreamsDemo();
        this.movies = streamsDemo.getMovies();
    }

    void collectInStreams() {
        toListOrSetOrMap();
        summingCollector();
        summarizingCollector();
        joiningCollector();
        partitioningBy();
        groupingCollector();
        partitioningBy();
    }

    /**
     * Collectors.toList(), Collectors.toSet(), Collectors.toMap()
     */
    private void toListOrSetOrMap() {
        List<Movie> movieList =
                movies.stream()
                        .filter(m1 -> m1.rating() >= 7.5)
                        .collect(Collectors.toList());
        System.out.println(movieList);

        Set<Movie> movieSet =
                movies.stream()
                        .filter(m11 -> m11.rating() >= 7.5)
                        .collect(Collectors.toSet());
        System.out.println(movieSet);

        Map<String, Float> movieMap =
                movies.stream()
                        .filter(m -> m.rating() >= 7.5)
                        .collect(Collectors.toMap(Movie::name, Movie::rating));
        System.out.println(movieMap);
    }

    /**
     * Collectors.summingDouble()
     */
    private void summingCollector() {
        Double sum =
                movies.stream()
                        .filter(m -> m.rating() >= 7.5)
                        .collect(Collectors.summingDouble(Movie::rating));
        System.out.println(sum);
    }

    /**
     * Collectors.summarizingDouble()
     */
    private void summarizingCollector() {
        DoubleSummaryStatistics summaryStatistics =
                movies.stream()
                        .filter(m11 -> m11.rating() >= 7.5)
                        .collect(Collectors.summarizingDouble(Movie::rating));
        System.out.println(summaryStatistics);
    }

    /**
     * Collectors.joining()
     */
    private void joiningCollector() {
        String goodMovieNames =
                movies.stream()
                        .filter(m1 -> m1.rating() >= 7.5)
                        .map(Movie::name)
                        .collect(Collectors.joining(", "));
        System.out.println(goodMovieNames);
    }

    /**
     * Collectors.groupingBy()
     */
    private void groupingCollector() {
        Map<Genre, List<Movie>> group1 =
                movies.stream()
                        .collect(Collectors.groupingBy(Movie::genre));
        System.out.println(group1);

        Map<Genre, Set<Movie>> group2 =
                movies.stream()
                        .collect(Collectors.groupingBy(Movie::genre, Collectors.toSet()));
        System.out.println(group2);

        Map<Genre, Long> group3 =
                movies.stream()
                        .collect(Collectors.groupingBy(Movie::genre, Collectors.counting()));
        System.out.println(group3);

        Map<Genre, String> group4 =
                movies.stream()
                        .collect(Collectors.groupingBy(
                                        Movie::genre,
                                        Collectors.mapping(Movie::name, Collectors.joining(", "))
                                )
                        );
        System.out.println(group4);
    }

    /**
     * Collectors.partitioningBy()
     */
    private void partitioningBy() {
        Map<Boolean, List<Movie>> group5 =
                movies.stream()
                        .collect(Collectors.partitioningBy(m -> m.rating() >= 7.0));
        System.out.println("Partitioning of movies on basis of rating=7.0");
        System.out.println(group5);

        Map<Boolean, String> group6 =
                movies.stream()
                        .collect(Collectors.partitioningBy(
                                        m -> m.rating() >= 7.0,
                                        Collectors.mapping(Movie::name, Collectors.joining(", "))
                                )
                        );
        System.out.println("Partitioning of movies on basis of rating=7.0, and also mapping the result to get the names of movies, separated with ','.");
        System.out.println(group6);
    }
}