package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class LibraryTest {

    Book book1 = new Book("We", "Yevgeni Zamiatin", "1924");
    Book book2 = new Book("Master and Margarita", "Mikhail Bulgakov", "1967");
    Book book3 = new Book("Death and the penguin", "Andrey Kurkov", "1996");
    ArrayList<Book> books = new ArrayList<>(Arrays.asList(book1, book2));
    Library library = new Library(books);

    @Test
    public void returnsBookIsInLibrary() {

        assertEquals(true, library.bookIsInLibrary(book1.getTitle()));
    }

    @Test
    public void returnsBookIsNotInLibrary() {

        assertEquals(false, library.bookIsInLibrary(book3.getTitle()));
    }

    @Test
    public void libraryGivesBookFromTitle() {
        String title = "We";
        assertEquals(book1, library.getBookFromTitle(title));
    }
}