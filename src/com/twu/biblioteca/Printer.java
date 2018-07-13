package com.twu.biblioteca;

class Printer {

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
