package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    public ArrayList<Book> getListOfBooks() {
        return ListOfBooks;
    }

    public Library(ArrayList<Book> listOfBooks) {
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


    public Book getBookFromTitle(String title) {
        for (Book book : ListOfBooks)
            if (title.equals(book.getTitle())) return book;
        return null;
    }
}
