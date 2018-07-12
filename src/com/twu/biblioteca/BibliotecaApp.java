package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApp {

    public static void main(String[] args) {


        Book book1 = new Book("Moby Dick", "Herman Melville", "1851");
        Book book2 = new Book("We", "Yevgeni Zamiatin", "1924");
        Book book3 = new Book("Harry Potter and teh philosopher's stone", "J K Rowling", "1998");
        ArrayList<Book> books = new ArrayList<>(Arrays.asList(book1, book2, book3));
        Library library = new Library(books);
        InputReader inputReader = new InputReader();


        ArrayList<Book> books2 = new ArrayList<>();
        Library library2 = new Library(books2);




        Runner runner = new Runner(library, inputReader);
        runner.Run();


    }
}
