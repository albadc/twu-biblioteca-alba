package com.twu.biblioteca;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibrarianTest {
    Library library = mock(Library.class);
    Book book = new Book("We", "Yevgeni Zamiatin", "1924");
    Movie movie = new Movie("X-Men: First Class", "Matthew Vaughn", "2011", 7.8);
    UserBookLog userBookLog = mock(UserBookLog.class);
    User user = new User("123-4567", "1234");
    Librarian librarian = new Librarian(library, userBookLog, user);

    @Test
    public void shouldSetAvailableToFalseWhenCheckOutBookSuccessfully() {
        when(library.bookIsInLibrary("We")).thenReturn(true);
        when(library.getBookFromTitle("We")).thenReturn(Optional.of(book));

        Optional<Book> expectedBook = librarian.checkOutBook("We");

        assertFalse(expectedBook.get().isAvailable());
    }

    @Test
    public void shouldFailCheckOutWhenBookIsNotInLibrary() {
        when(library.bookIsInLibrary("You")).thenReturn(false);

        Optional<Book> expectedBook = librarian.checkOutBook("You");

        assertFalse(expectedBook.isPresent());
    }

    @Test
    public void shouldFailCheckOutWhenBookIsNotAvailable() {
        book.checkOut();
        when(library.bookIsInLibrary("We")).thenReturn(true);
        when(library.getBookFromTitle("We")).thenReturn(Optional.of(book));

        Optional<Book> we = librarian.checkOutBook("We");

        assertFalse(we.isPresent());
    }

    @Test
    public void shouldSetAvailableToTrueWhenReturningCheckedOutBook() {
        when(library.bookIsInLibrary("We")).thenReturn(true);
        when(library.getBookFromTitle("We")).thenReturn(Optional.of(book));
        when(userBookLog.hasUserCheckedOutBook(user, book)).thenReturn(true);

        book.checkOut();

        Optional<Book> expectedBook = librarian.returnBook("We");

        assertTrue(expectedBook.get().isAvailable());
    }

    @Test
    public void shouldFailReturnWhenBookHasNotBeenCheckedOut() {
        when(library.bookIsInLibrary("We")).thenReturn(true);
        when(library.getBookFromTitle("We")).thenReturn(Optional.of(book));
        when(userBookLog.hasUserCheckedOutBook(user, book)).thenReturn(false);

        Optional<Book> we = librarian.returnBook("We");

        assertFalse(we.isPresent());
    }

    @Test
    public void shouldFailReturnWhenBookIsNotFromLibrary() {
        when(library.bookIsInLibrary("We")).thenReturn(false);

        Optional<Book> you = librarian.returnBook("You");

        assertFalse(you.isPresent());
    }

    @Test
    public void shouldSetAvailableToFalseWhenCheckingOutAvailableMovie() {
        when(library.movieIsInLibrary("X-Men: First Class")).thenReturn(true);
        when(library.getMovieFromName("X-Men: First Class")).thenReturn(Optional.of(movie));

        Optional<Movie> expectedMovie = librarian.checkOutMovie("X-Men: First Class");

        assertFalse(expectedMovie.get().isAvailable());
    }

    @Test
    public void shouldFailCheckOutWhenMovieIsNotInLibrary() {
        when(library.movieIsInLibrary("X-Men: First Class")).thenReturn(false);

        Optional<Movie> expectedMovie = librarian.checkOutMovie("X-Men: First Class");

        assertFalse(expectedMovie.isPresent());
    }

    @Test
    public void shouldFailCheckOutWhenMovieIsNotAvailable() {
        when(library.movieIsInLibrary("X-Men: First Class")).thenReturn(true);
        when(library.getMovieFromName("X-Men: First Class")).thenReturn(Optional.of(movie));
        movie.checkOut();

        Optional<Movie> expectedMovie = librarian.checkOutMovie("X-Men: First Class");

        assertFalse(expectedMovie.isPresent());
    }

    @Test
    public void shouldAddBookToLogWhenUserChecksOutBook() {
        userBookLog = new UserBookLog();
        Librarian librarian = new Librarian(library, userBookLog, user);


        when(library.bookIsInLibrary("We")).thenReturn(true);
        when(library.getBookFromTitle("We")).thenReturn(Optional.of(book));

        userBookLog.addUserToLog(user);
        librarian.checkOutBook("We");

        assertTrue(userBookLog.hasUserCheckedOutBook(user, book));

    }

    @Test
    public void shouldRemoveBookFromLogWhenUserReturnsBook() {
        userBookLog = new UserBookLog();
        Librarian librarian = new Librarian(library, userBookLog, user);

        when(library.bookIsInLibrary("We")).thenReturn(true);
        when(library.getBookFromTitle("We")).thenReturn(Optional.of(book));

        userBookLog.addUserToLog(user);
        librarian.returnBook("We");

        assertFalse(userBookLog.hasUserCheckedOutBook(user, book));
    }
}
