package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BookTest {



    @Test
    public void bookIsCheckedOut() {
        Book book = new Book("We", "Yevgeni Zamiatin", "1924");

        assertEquals(true, book.isAvailable());
        book.checkOut();
        assertEquals(false, book.isAvailable());

    }

    @Test
    public void bookIsReturned() {
        Book book = new Book("We", "Yevgeni Zamiatin", "1924");
        book.checkOut();
        book.returnBook();

        assertEquals(true, book.isAvailable());

    }
}
