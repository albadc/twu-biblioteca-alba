package com.twu.biblioteca;

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
        if (library.bookIsInLibrary(bookTitle)) {
            Book book = library.getBookFromTitle(bookTitle);
            if (!book.isAvailable()) {
                book.returnBook();
                printer.successfulReturnMessage();
            }
            else printer.unsuccessfulReturnMessage();

        }
        else printer.unsuccessfulReturnMessage();
    }

    void checkOutBook() {
        printer.initialCheckOutMessage();
        String bookTitle = inputReader.getBookTitle();
        if (library.bookIsInLibrary(bookTitle)) {
            Book book = library.getBookFromTitle(bookTitle);
            if (book.isAvailable()) {
                book.checkOut();
                printer.successfulCheckOutMessage();
            }
            else printer.unsuccessfulCheckOutMessage();

        }
        else printer.unsuccessfulCheckOutMessage();

    }


    private void showListOfBooks() {
        if (library.getListOfBooks().isEmpty()) {
            printer.emptyLibraryMessage();
        } else {
            printer.listOfBooks(library);
        }

    }
}
