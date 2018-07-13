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
    public void successfulCheckOut() {

            String input = "We";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            runner.checkOutBook();

            assertThat(outContent.toString(), containsString("Thank you! Enjoy the book"));

    }


    @Test
    public void unsuccessfulCheckOutBecauseBookIsNotInLibrary() {
        String input = "You";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        runner.checkOutBook();

        assertThat(outContent.toString(), containsString("That book is not available"));
    }

    @Test
    public void unsuccessfulCheckOutBecauseBookIsNotAvailable() {
        String input = "You";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        book.checkOut();

        runner.checkOutBook();


        assertThat(outContent.toString(), containsString("That book is not available"));
    }

    @Test
    public void successfulReturn() {

        String input = "We";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        book.checkOut();

        runner.returnBook();

        assertThat(outContent.toString(), containsString("Thank you for returning the book"));

    }

    @Test
    public void unsuccessfulReturnBecauseBookIsAlreadyInLibrary() {

        String input = "We";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        runner.returnBook();

        assertThat(outContent.toString(), containsString("That is not a valid book to return"));

    }

    @Test
    public void unsuccessfulReturnBecauseBookIsNotFromLibrary() {

        String input = "You";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        runner.returnBook();

        assertThat(outContent.toString(), containsString("That is not a valid book to return"));

    }


}