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
        User user = new User("123-4567", "1234");
        User user2 = new User("234-5678", "2345");
        user.setEmail("happyPenguin23@gmail.com");
        user.setName("Misha");
        user.setPhoneNumber("666777888");
        user2.setName("Luna");
        user2.setEmail("happyCat5@protonmail.com");
        user2.setPhoneNumber("678901234");
        ArrayList<User> validUsers = new ArrayList<>(Arrays.asList(user, user2));
        Users users = new Users(validUsers);


//        ArrayList<Book> books2 = new ArrayList<>();
//        Library library2 = new Library(books2);

        UserBookLog userBookLog = new UserBookLog();


        Runner runner = new Runner(library, inputReader, printer, users, userBookLog);
        runner.start();



    }


}
