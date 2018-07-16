package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BibliotecaApp {

    public static void main(String[] args) {



        Book book1 = new Book("We", "Yevgeni Zamiatin", "1924");
        Book book2 = new Book("Master and Margarita", "Mikhail Bulgakov", "1967");
        Book book3 = new Book("Death and the penguin", "Andrey Kurkov", "1996");
        ArrayList<Book> books = new ArrayList<>(Arrays.asList(book1, book2, book3));
        Movie movie = new Movie("X-Men: First Class", "Matthew Vaughn", "2011", 7.8);
        ArrayList<Movie> movies = new ArrayList<>((Collections.singletonList(movie)));
        Library library = new Library(books, movies);
        InputReader inputReader = new InputReader();
        Printer printer = new Printer();


//        ArrayList<Book> books2 = new ArrayList<>();
//        Library library2 = new Library(books2);




        Runner runner = new Runner(library, inputReader, printer);
        runner.start();


    }
}
