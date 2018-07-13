package com.twu.biblioteca;

class Printer {
    private static final String TAB = "\t";

    void welcomeMessage() {
        System.out.println("Welcome to Biblioteca!");
    }

    void showMainMenu() {
        System.out.println("Main Menu:\n" +
                "1 - List Books\n" +
                "2 - Check Out Book\n" +
                "3 - Return Book\n" +
                "4 - Quit\n");
    }

    void selectChoiceNumber() {
        System.out.println("Please enter a number");
    }

    void invalidOption() {
        System.out.println("Select a valid option!");
    }

    void emptyLibraryMessage() {
        System.out.println("There are currently no books in the library");
    }

    void listOfBooks(Library library) {
        System.out.println("Books currently in the library:");
        System.out.println("Title" + TAB + "Author" + TAB + "Year");
        for (Book book : library.getListOfBooks()) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle() + TAB + book.getAuthor() + TAB + book.getYear());
            }
        }
    }

    void initialCheckOutMessage() {
        System.out.println("Please enter the name of the book you want to check out");
    }

    void initialReturnMessage() {
        System.out.println("Please enter the name of the book you are returning");
    }


    void successfulCheckOutMessage() {
        System.out.println("Thank you! Enjoy the book");
    }

    void unsuccessfulCheckOutMessage() {
        System.out.println("That book is not available");
    }

    void unsuccessfulReturnMessage() {
        System.out.println("That is not a valid book to return");
    }


    void successfulReturnMessage() {
        System.out.println("Thank you for returning the book");
    }
}
