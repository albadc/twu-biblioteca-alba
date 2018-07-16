package com.twu.biblioteca;

import java.util.Optional;

class Runner {

    private final Librarian librarian = new Librarian(this);
    private InputReader inputReader;
    private Printer printer;
    private Library library;

    Runner(Library library, InputReader inputReader, Printer printer) {
        this.library = library;
        this.inputReader = inputReader;
        this.printer = printer;
    }


    void start() {
        printer.welcomeMessage();
        printer.showMainMenu();
        while (true) {
            printer.selectChoiceNumber();
            int userNumber = inputReader.getUserNumber();
            if (userNumber == -1) printer.invalidOption();
            else if (userNumber == 1) showListOfBooks();
            else if (userNumber == 2) librarian.checkOutBook();
            else if (userNumber == 3) librarian.returnBook();
            else if (userNumber == 4) break;
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
}
