package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserTest {
    User user = new User("123-4567", "1234");

    @Test
    public void successfulLogIn() {

        assertTrue(user.logIn("123-4567", "1234"));
    }


}