package com.twu.biblioteca;

class Runner {
    private static final String END_LINE = "\n";
    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca!\n";
    private static final String MAIN_MENU = "Main Menu:\n" +
            "1 - List Books\n" +
            "2 - Check Out Book\n" +
            "3 - Return Book\n" +
            "4 - Quit\n";
    private static final String TAB = "\t";


    private InputReader inputReader;
    private Printer printer;
    private Library library;

    Runner(Library library, InputReader inputReader, Printer printer) {
        this.library = library;
        this.inputReader = inputReader;
        this.printer = printer;
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

    private void welcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    private void showMainMenu() {
        System.out.println(MAIN_MENU);

    }
}
