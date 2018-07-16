package com.twu.biblioteca;

import java.util.Optional;

public class Movie {

    private String name;
    private String director;
    private String year;
    private double rating;
    private boolean isAvailable = true;

    Movie(String name, String director, String year, double rating) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    String getName() {
        return name;
    }

    String getDirector() {
        return director;
    }

    String getYear() {
        return year;
    }

    double getRating() {
        return rating;
    }

    boolean isAvailable() {
        return isAvailable;
    }

    void setAvailable(boolean available) {
        isAvailable = available;
    }

    Optional<Movie> checkOut() {
        setAvailable(false);
        return Optional.of(this);
    }
}
