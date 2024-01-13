package dev.mayankg.streams.Util;

import java.util.Comparator;

public class MovieRatingComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie m1, Movie m2) {
        // reverse order (desc)
        return (int) (m2.getRating() - m1.getRating());
    }
}