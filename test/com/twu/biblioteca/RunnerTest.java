package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;


public class RunnerTest {

    Book book = new Book("We", "Yevgeni Zamiatin", "1924");
    ArrayList<Book> books = new ArrayList<>(Arrays.asList(book));
    Movie movie = new Movie("X-Men: First Class", "Matthew Vaughn", "2011", 7.8);
    ArrayList<Movie> movies = new ArrayList<>((Collections.singletonList(movie)));
    Library library = new Library(books, movies);
    InputReader inputReader = new InputReader();
    Printer printer = new Printer();
    User user = new User("123-456", "1234");
    ArrayList<User> validUsers = new ArrayList<>(Collections.singletonList(user));
    Users users = new Users(validUsers);
    Runner runner = new Runner(library, inputReader, printer, users);

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

    @Test
    public void showMovieInListOfMoviesIfItIsAvailable() {
        runner.showListOfMovies();

        assertThat(outContent.toString(), containsString("Movies currently in the library:" +
                "\n" + "Name" + "\t" + "Director" + "\t" + "Year" + "\t" + "Rating"
                + "\n" + "X-Men: First Class" + "\t" + "Matthew Vaughn" + "\t" + "2011" + "\t" + "7.8"));

    }

    @Test
    public void notShowMovieInListOfMoviesIfItIsNotAvailable() {
        movie.checkOut();
        runner.showListOfMovies();
        assertThat(outContent.toString(), containsString("There are currently no movies in the library"));
    }


}