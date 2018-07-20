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
                "4 - List Movies\n" +
                "5 - Check Out Movie\n" +
                "6 - Check user information\n" +
                "7 - Log out\n" +
                "8 - Quit\n");
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

    void listOfMovies(Library library) {
        System.out.println("Movies currently in the library:");
        System.out.println("Name" + TAB + "Director" + TAB + "Year" + TAB + "Rating");
        for (Movie movie : library.getListOfMovies()) {
            if (movie.isAvailable()) {
                System.out.println(movie.getName() + TAB + movie.getDirector() + TAB + movie.getYear() + TAB + movie.getRating());
            }
        }
    }

    void emptyMoviesMessage() {
        System.out.println("There are currently no movies in the library");
    }

    void initialCheckOutMessageForMovie() {
        System.out.println("Please enter the name of the movie you want to check out");
    }

    void successfulCheckOutMessageForMovie() {
        System.out.println("Thank you! Enjoy the movie");
    }

    void unsuccessfulCheckOutMessageForMovie() {
        System.out.println("That movie is not available");
    }

    void askLoginInNumber() {
        System.out.println("Please input your library number");
    }

    void wrongLogIn() {
        System.out.println("Please input a valid log in number of format xxx-xxxx");
    }

    void correctLogIn() {
        System.out.println("Successfully logged in");
    }

    void unableToLogInMessage() {
        System.out.println("Unsuccessful log in. Please try again");
    }

    void askPassword() {
        System.out.println("Please input your password");
    }

    void showUserInfo(User user) {
        System.out.println(user.getName() + TAB + user.getEmail() + TAB + user.getPhoneNumber());
    }

    void successfulLogOut() {
        System.out.println("Successfully logged out. Thank you for using Biblioteca!");
    }
}
