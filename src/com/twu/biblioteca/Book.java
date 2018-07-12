package com.twu.biblioteca;

public class Book {
    Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    private String title;
    private String author;
    private String year;
    private boolean isAvailable = true;





    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }


    String getYear() {
        return year;
    }

    boolean isAvailable() {
        return isAvailable;
    }

    void setAvailable(boolean available) {
        isAvailable = available;
    }



    void checkOut() {
        setAvailable(false);
    }

    void returnBook() {
        setAvailable(true);
    }
}
