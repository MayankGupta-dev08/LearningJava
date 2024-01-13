package dev.mayankg.streams.Util;

import java.util.Comparator;

public class MovieRatingComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie m1, Movie m2) {
        return (int) (m1.getRating() - m2.getRating());
    }
}