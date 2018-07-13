package com.twu.biblioteca;

import java.util.ArrayList;

class Library {
    ArrayList<Book> getListOfBooks() {
        return ListOfBooks;
    }

    Library(ArrayList<Book> listOfBooks) {
        ListOfBooks = listOfBooks;
    }

    private ArrayList<Book> ListOfBooks;

    boolean bookIsInLibrary(String title) {
        for (Book book : ListOfBooks) {
            if (title.equals(book.getTitle())) {
                return true;
            }
        }
        return false;
    }

    Book getBookFromTitle(String title) {
        for (Book book : ListOfBooks)
            if (title.equals(book.getTitle())) return book;
        return null;
    }

    boolean noAvailableBooks() {
        for (Book book : ListOfBooks) {
            if (book.isAvailable()) return false;
        }
        return true;
    }
}
