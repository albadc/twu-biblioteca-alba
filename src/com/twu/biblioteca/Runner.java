package com.twu.biblioteca;

class Runner {

    private final Librarian librarian;
    private InputReader inputReader;
    private Printer printer;
    private Library library;
    private Users users;
    private User user;
    private UserBookLog userBookLog;

    void setUser(User user) {
        this.user = user;
    }

    Runner(Library library, InputReader inputReader, Printer printer, Users users, UserBookLog userBookLog) {
        this.library = library;
        this.inputReader = inputReader;
        this.printer = printer;
        this.users = users;
        this.userBookLog = userBookLog;
        this.librarian = new Librarian(this.library, this.userBookLog, this.user);
    }

    void start() {
        printer.welcomeMessage();
        if (ableToLogin()) {
            userBookLog.addUserToLog(user);
            printer.correctLogIn();
            printer.showMainMenu();
            while (true) {
                printer.selectChoiceNumber();
                int userNumber = inputReader.getUserNumber();
                if (userNumber == -1) printer.invalidOption();
                else if (userNumber == 1) showListOfBooks();
                else if (userNumber == 2) checkOutBook();
                else if (userNumber == 3) returnBook();
                else if (userNumber == 4) showListOfMovies();
                else if (userNumber == 5) checkOutMovie();
                else if (userNumber == 6) printer.showUserInfo(user);
                else if (userNumber == 7) break;
            }
        } else {
            printer.unableToLogInMessage();
            start();
        }
    }


    void showListOfBooks() {
        if (library.getListOfBooks().isEmpty() || library.hasNoAvailableBooks()) {
            printer.emptyLibraryMessage();
        } else {
            printer.listOfBooks(library);
        }

    }


    void showListOfMovies() {
        if (library.getListOfMovies().isEmpty() || library.hasNoAvailableMovies()) {
            printer.emptyMoviesMessage();
        } else {
            printer.listOfMovies(library);
        }

    }

    void checkOutBook() {
        printer.initialCheckOutMessage();
        String bookTitle = inputReader.getTitle();
        if (librarian.checkOutBook(bookTitle).isPresent()) {
            printer.successfulCheckOutMessage();
        } else {
            printer.unsuccessfulCheckOutMessage();
        }
    }

    void returnBook() {
        printer.initialReturnMessage();
        String bookTitle = inputReader.getTitle();
        if (librarian.returnBook(bookTitle).isPresent()) {
            printer.successfulReturnMessage();
        } else {
            printer.unsuccessfulReturnMessage();
        }

    }

    boolean ableToLogin() {
        printer.askLoginInNumber();
        String loginNumber = inputReader.getLoginNumber();
        if (users.isUserInUsersDB(loginNumber)) {
            setUser(users.getUserFromLoginNumber(loginNumber).get());
            printer.askPassword();
            String password = inputReader.getPassword();
            return user.logIn(loginNumber, password);
        } else {
            printer.wrongLogIn();
            return false;
        }
    }

    void checkOutMovie() {
        printer.initialCheckOutMessageForMovie();
        String movieTitle = inputReader.getTitle();
        if (librarian.checkOutMovie(movieTitle).isPresent()) {
            printer.successfulCheckOutMessageForMovie();
        } else {
            printer.unsuccessfulCheckOutMessageForMovie();
        }
    }
}
