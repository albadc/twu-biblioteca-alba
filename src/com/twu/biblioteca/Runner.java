package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class Runner {
    private static final String END_LINE = "\n";
    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca!\n";
    private static final String MAIN_MENU = "Main Menu:\n" +
            "1 - List Books\n" +
            "2 - Check Out Book\n" +
            "3 - Return Book\n" +
            "4 - Quit\n";
    public static final String TAB = "\t";


    private InputReader inputReader;
    private Library library;

    public Runner(Library library, InputReader inputReader) {
        this.library = library;
        this.inputReader = inputReader;
    }


    void Run() {

        welcomeMessage();
        showMainMenu();
        start();


    }

    private void start() {
        while (true) {
            System.out.println("Please enter a number\n");
            int userNumber = inputReader.getUserNumber();
            if (userNumber == -1) System.out.println("Select a valid option!\n");
            else if (userNumber == 1) showListOfBooks();
            else if (userNumber == 2) checkOutBook();
            else if (userNumber == 3) returnBook();
            else if (userNumber == 4) break;



        }

    }

    private void returnBook() {
        System.out.println("Please enter the name of the book you are returning" + END_LINE);
        String bookTitle = inputReader.getBookTitle();
        if (library.bookIsInLibrary(bookTitle)) {
            Book book = library.getBookFromTitle(bookTitle);
            if (!book.isAvailable()) {
                book.returnBook();
                System.out.println("Thank you for returning the book");
            }
            else System.out.println("That is not a valid book to return");

        }
        else System.out.println("That is not a valid book to return");
    }

    private void checkOutBook() {
        System.out.println("Please enter the name of the book you want to check out" + END_LINE);
        String bookTitle = inputReader.getBookTitle();
        if (library.bookIsInLibrary(bookTitle)) {
            Book book = library.getBookFromTitle(bookTitle);
            if (book.isAvailable()) {
                book.checkOut();
                System.out.println("Thank you! Enjoy the book");
            }
            else System.out.println("That book is not available");

        }
        else System.out.println("That book is not available");

    }

    private void showListOfBooks() {
        if (library.getListOfBooks().isEmpty()) {
            System.out.println("There are currently no books in the library");
        } else {
            System.out.println("Books currently in the library:" + END_LINE);
            System.out.println("Title" + TAB + "Author" + TAB + "Year" + END_LINE);
            for (Book book : library.getListOfBooks()) {
                if (book.isAvailable()) {
                    System.out.println(book.getTitle() + TAB + book.getAuthor() + TAB + book.getYear() + TAB + END_LINE);
                }
            }
        }

    }

    public void welcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    void showMainMenu() {
        System.out.println(MAIN_MENU);

    }
}
