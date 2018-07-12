package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class RunnerTest {

    Book book1 = new Book("Moby Dick", "Herman Melville", "1851");
    Book book2 = new Book("We", "Yevgeni Zamiatin", "1924");
    ArrayList<Book> books = new ArrayList<>(Arrays.asList(book1, book2));
    Library library = new Library(books);
    InputReader inputReader = new InputReader();

    Runner runner = new Runner(library, inputReader);

    @Test
    public void successfulCheckOut() {


    }

    @Test
    public void unsuccessfulCheckOutBecauseBookIsNotInLibrary() {
    }
}