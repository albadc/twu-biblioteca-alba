package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

class Library {
    ArrayList<Book> getListOfBooks() {
        return ListOfBooks;
    }

    Library(ArrayList<Book> listOfBooks) {
        ListOfBooks = listOfBooks;
    }

    private ArrayList<Book> ListOfBooks;

    boolean bookIsInLibrary(String title) {
        return ListOfBooks.stream().anyMatch(book -> title.equals(book.getTitle()));
    }

    Optional<Book> getBookFromTitle(String title) {
        return ListOfBooks.stream().filter(book -> title.equals(book.getTitle())).findFirst();
    }

    boolean hasNoAvailableBooks() {
        return ListOfBooks.stream().noneMatch(Book::isAvailable);
    }
}
