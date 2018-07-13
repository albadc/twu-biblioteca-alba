package com.twu.biblioteca;

import java.util.Optional;

class Book {
    Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    private String title;
    private String author;
    private String year;
    private boolean isAvailable = true;


    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    String getYear() {
        return year;
    }

    boolean isAvailable() {
        return isAvailable;
    }

    private void setAvailable(boolean available) {
        isAvailable = available;
    }

    Optional<Book> checkOut() {
        setAvailable(false);
        return Optional.of(this);
    }

    Optional<Book> returnBook() {
        setAvailable(true);
        return Optional.of(this);
    }
}
