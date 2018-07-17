package com.twu.biblioteca;

import java.util.Optional;

public class Librarian {
    private Library library;

    public Librarian(Library library) {
        this.library = library;
    }


    Optional<Book> checkOutBook(String bookTitle) {

        if (library.bookIsInLibrary(bookTitle)) {
            Book book = library.getBookFromTitle(bookTitle).get();
            if (book.isAvailable()) {
                return book.checkOut();
            } else return Optional.empty();
        } else return Optional.empty();
    }

    Optional<Book> returnBook(String bookTitle) {
        if (library.bookIsInLibrary(bookTitle)) {
            Book book = library.getBookFromTitle(bookTitle).get();
            if (!book.isAvailable()) {
                return book.returnBook();
            } else return Optional.empty();
        }
        return Optional.empty();
    }

    Optional<Movie> checkOutMovie(String movieTitle) {
        if (library.movieIsInLibrary(movieTitle)) {
            Movie movie = library.getMovieFromName(movieTitle).get();
            if (movie.isAvailable()) {
                return movie.checkOut();
            } else return Optional.empty();
        }
        return Optional.empty();
    }
}