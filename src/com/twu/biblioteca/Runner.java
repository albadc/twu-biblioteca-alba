package com.twu.biblioteca;

import java.util.Optional;

class Runner {

    private final Librarian librarian = new Librarian(this);
    private InputReader inputReader;
    private Printer printer;
    private Library library;

    private Users users;

    private User user;

    User getUser() {
        return user;
    }

    void setUser(User user) {
        this.user = user;
    }

    Runner(Library library, InputReader inputReader, Printer printer, Users users) {
        this.library = library;
        this.inputReader = inputReader;
        this.printer = printer;
        this.users = users;
    }

    Users getUsers() {
        return users;
    }

    void start() {
        printer.welcomeMessage();
        if (librarian.ableToLogin()) {
            printer.correctLogIn();
            printer.showMainMenu();
            while (true) {
                printer.selectChoiceNumber();
                int userNumber = inputReader.getUserNumber();
                if (userNumber == -1) printer.invalidOption();
                else if (userNumber == 1) showListOfBooks();
                else if (userNumber == 2) librarian.checkOutBook();
                else if (userNumber == 3) librarian.returnBook();
                else if (userNumber == 4) showListOfMovies();
                else if (userNumber == 5) librarian.checkOutMovie();
                else if (userNumber == 6) printer.showUserInfo(user);
                else if (userNumber == 7) break;
            }
        } else {
            printer.unableToLogInMessage();
            start();
        }
    }


    Optional<Book> returnBook(String bookTitle) {
        if (library.bookIsInLibrary(bookTitle)){
            Book book = library.getBookFromTitle(bookTitle).get();
            if (!book.isAvailable()) {
                return book.returnBook();
            }
            else return Optional.empty();
        }
        return Optional.empty();
    }


    Optional<Book> checkOutBook(String bookTitle) {

        if (library.bookIsInLibrary(bookTitle)) {
            Book book = library.getBookFromTitle(bookTitle).get();
            if (book.isAvailable()) {
                return book.checkOut();
            }
            else return Optional.empty();
        }
        else return Optional.empty();
    }


    void showListOfBooks() {
        if (library.getListOfBooks().isEmpty() || library.hasNoAvailableBooks()) {
            printer.emptyLibraryMessage();
        } else {
            printer.listOfBooks(library);
        }

    }

    Printer getPrinter() {
        return printer;
    }

    InputReader getInputReader() {
        return inputReader;
    }

    void showListOfMovies() {
        if (library.getListOfMovies().isEmpty() || library.hasNoAvailableMovies()) {
            printer.emptyMoviesMessage();
        } else {
            printer.listOfMovies(library);
        }

    }

    Optional<Movie> checkOutMovie(String movieTitle) {
        if (library.movieIsInLibrary(movieTitle)) {
            Movie movie = library.getMovieFromName(movieTitle).get();
            if (movie.isAvailable()) {
                return movie.checkOut();
            } else return Optional.empty();
        }
        return Optional.empty();
    }
}
