package com.twu.biblioteca;

public class Librarian {
    private final Runner runner;

    public Librarian(Runner runner) {
        this.runner = runner;
    }

    void returnBook() {
        runner.getPrinter().initialReturnMessage();
        String bookTitle = runner.getInputReader().getBookTitle();
        if (runner.returnBook(bookTitle).isPresent()) {
            runner.getPrinter().successfulReturnMessage();
        } else {
            runner.getPrinter().unsuccessfulReturnMessage();
        }

    }

    void checkOutBook() {
        runner.getPrinter().initialCheckOutMessage();
        String bookTitle = runner.getInputReader().getBookTitle();
        if (runner.checkOutBook(bookTitle).isPresent()) {
            runner.getPrinter().successfulCheckOutMessage();
        } else {
            runner.getPrinter().unsuccessfulCheckOutMessage();
        }
    }
}