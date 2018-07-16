package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Optional;

class Library {

    private ArrayList<Book> listOfBooks;
    private ArrayList<Movie> listOfMovies;

    Library(ArrayList<Book> listOfBooks, ArrayList<Movie> listOfMovies) {
        this.listOfBooks = listOfBooks;
        this.listOfMovies = listOfMovies;
    }

    ArrayList<Book> getListOfBooks() {
        return listOfBooks;
    }

    boolean bookIsInLibrary(String title) {
        return listOfBooks.stream().anyMatch(book -> title.equals(book.getTitle()));
    }

    Optional<Book> getBookFromTitle(String title) {
        return listOfBooks.stream().filter(book -> title.equals(book.getTitle())).findFirst();
    }

    boolean hasNoAvailableBooks() {
        return listOfBooks.stream().noneMatch(Book::isAvailable);
    }

    ArrayList<Movie> getListOfMovies() {
        return listOfMovies;
    }

    boolean hasNoAvailableMovies() {
        return listOfMovies.stream().noneMatch(Movie::isAvailable);

    }
}
