package com.twu.biblioteca;

public class Librarian {
    private final Runner runner;

    public Librarian(Runner runner) {
        this.runner = runner;
    }

    void returnBook() {
        runner.getPrinter().initialReturnMessage();
        String bookTitle = runner.getInputReader().getTitle();
        if (runner.returnBook(bookTitle).isPresent()) {
            runner.getPrinter().successfulReturnMessage();
        } else {
            runner.getPrinter().unsuccessfulReturnMessage();
        }

    }

    void checkOutBook() {
        runner.getPrinter().initialCheckOutMessage();
        String bookTitle = runner.getInputReader().getTitle();
        if (runner.checkOutBook(bookTitle).isPresent()) {
            runner.getPrinter().successfulCheckOutMessage();
        } else {
            runner.getPrinter().unsuccessfulCheckOutMessage();
        }
    }

    public void checkOutMovie() {
        runner.getPrinter().initialCheckOutMessageForMovie();
        String movieTitle = runner.getInputReader().getTitle();
        if (runner.checkOutMovie(movieTitle).isPresent()) {
            runner.getPrinter().successfulCheckOutMessageForMovie();
        } else {
            runner.getPrinter().unsuccessfulCheckOutMessageForMovie();
        }
    }
}