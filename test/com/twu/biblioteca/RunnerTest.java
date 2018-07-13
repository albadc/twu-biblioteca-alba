package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;


public class RunnerTest {

    Book book = new Book("We", "Yevgeni Zamiatin", "1924");
    ArrayList<Book> books = new ArrayList<>(Arrays.asList(book));
    Library library = new Library(books);
    InputReader inputReader = new InputReader();
    Printer printer = new Printer();
    Runner runner = new Runner(library, inputReader, printer);

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void showBookInListOfBooksIfItIsAvailable() {
        runner.showListOfBooks();

        assertThat(outContent.toString(), containsString("Books currently in the library:" +
                "\n" + "Title" + "\t" + "Author" + "\t" + "Year" +
                "\n" + "We" + "\t" + "Yevgeni Zamiatin" + "\t" + "1924"));
    }

    @Test
    public void notShowBookInListOfBooksIfNotAvailable() {
        book.checkOut();
        runner.showListOfBooks();

        assertThat(outContent.toString(), containsString("There are currently no books in the library"));
    }

    @Test
    public void successfulCheckOut() {
        Optional<Book> we = runner.checkOutBook("We");
        assertFalse(we.get().isAvailable());
    }

    @Test
    public void unsuccessfulCheckOutBecauseBookIsNotInLibrary() {
        Optional<Book> you = runner.checkOutBook("You");
        assertFalse(you.isPresent());
    }

    @Test
    public void unsuccessfulCheckOutBecauseBookIsNotAvailable() {
        book.checkOut();
        Optional<Book> we = runner.checkOutBook("We");
        assertFalse(we.isPresent());
    }

    @Test
    public void successfulReturn() {
        book.checkOut();
        Optional<Book> we = runner.returnBook("We");
        assertTrue(we.get().isAvailable());
    }

    @Test
    public void unsuccessfulReturnBecauseBookIsAlreadyInLibrary() {
        Optional<Book> we = runner.returnBook("We");
        assertFalse(we.isPresent());
    }

    @Test
    public void unsuccessfulReturnBecauseBookIsNotFromLibrary() {
        Optional<Book> you = runner.returnBook("You");
        assertFalse(you.isPresent());
    }


}