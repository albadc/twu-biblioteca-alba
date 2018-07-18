package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserBookLogTest {

    UserBookLog userBookLog = new UserBookLog();
    User user;
    Book book = new Book("We", "Yevgeni Zamiatin", "1924");

    @Test
    public void shouldAddUserWhenUserLogsIn() {
        userBookLog.addUserToLog(user);

        assertTrue(userBookLog.isUserInLog(user));
    }

    @Test
    public void shouldReturnBookIsCheckedOutByUserWhenBookIsAddedToLog() {
        userBookLog.addBookToLog(user, book);

        assertTrue(userBookLog.hasUserCheckedOutBook(user, book));

    }


}