package dev.mayankg.streams.Util;

public record Movie(String name, float rating, Genre genre) implements Comparable<Movie> {

    @Override
    public String toString() {
        return "Movie{name='%s', rating=%s}".formatted(name, rating);
    }

    @Override
    public int compareTo(Movie that) {
        return this.name().compareTo(that.name());
    }
}