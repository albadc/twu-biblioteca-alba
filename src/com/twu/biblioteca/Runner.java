package com.twu.biblioteca;

import java.util.Optional;

class Runner {

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
            else if (userNumber == 2) checkOutBook();
            else if (userNumber == 3) returnBook();
            else if (userNumber == 4) break;
        }
    }

    void returnBook() {
        printer.initialReturnMessage();
        String bookTitle = inputReader.getBookTitle();
        if (returnBook(bookTitle).isPresent()) {
            printer.successfulReturnMessage();
        }
        else {
            printer.unsuccessfulReturnMessage();
        }

    }


    Optional<Book> returnBook(String bookTitle) {
        if (library.bookIsInLibrary(bookTitle)){
            Book book = library.getBookFromTitle(bookTitle);
            if (!book.isAvailable()) {
                return book.returnBook();
            }
            else return Optional.empty();
        }
        return Optional.empty();
    }


    void checkOutBook() {
        printer.initialCheckOutMessage();
        String bookTitle = inputReader.getBookTitle();
        if (checkOutBook(bookTitle).isPresent()) {
            printer.successfulCheckOutMessage();
        } else {
            printer.unsuccessfulCheckOutMessage();
        }
    }


    Optional<Book> checkOutBook(String bookTitle) {
        if (library.bookIsInLibrary(bookTitle)) {
            Book book = library.getBookFromTitle(bookTitle);
            if (book.isAvailable()) {
                return book.checkOut();
            }
            else return Optional.empty();
        }
        else return Optional.empty();
    }


    void showListOfBooks() {
        if (library.getListOfBooks().isEmpty() || library.noAvailableBooks()) {
            printer.emptyLibraryMessage();
        } else {
            printer.listOfBooks(library);
        }

    }
}
