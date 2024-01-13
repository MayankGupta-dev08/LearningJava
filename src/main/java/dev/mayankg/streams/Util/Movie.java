package dev.mayankg.streams.Util;

public class Movie implements Comparable<Movie>{
    private String name;
    private float rating;

    public Movie(String name, float rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{name='%s', rating=%s}".formatted(name, rating);
    }

    @Override
    public int compareTo(Movie that) {
        return this.getName().compareTo(that.getName());
    }
}