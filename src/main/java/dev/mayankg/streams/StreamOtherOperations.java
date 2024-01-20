package dev.mayankg.streams;

import dev.mayankg.streams.Util.Movie;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOtherOperations {
    private final List<Movie> movies;

    StreamOtherOperations() {
        StreamsDemo streamsDemo = new StreamsDemo();
        this.movies = streamsDemo.getMovies();
    }

    void collectInStreams() {
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

        Double sum =
                movies.stream()
                        .filter(m -> m.rating() >= 7.5)
                        .collect(Collectors.summingDouble(Movie::rating));
        System.out.println(sum);

        DoubleSummaryStatistics summaryStatistics =
                movies.stream()
                        .filter(m11 -> m11.rating() >= 7.5)
                        .collect(Collectors.summarizingDouble(Movie::rating));
        System.out.println(summaryStatistics);

        String goodMovieNames =
                movies.stream()
                        .filter(m1 -> m1.rating() >= 7.5)
                        .map(Movie::name)
                        .collect(Collectors.joining(", "));
        System.out.println(goodMovieNames);
    }


}