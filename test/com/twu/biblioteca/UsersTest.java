package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.*;

public class UsersTest {
    User user = new User("123-4567", "1234");
    User invalidUser = new User("345-1234", "hello");
    ArrayList<User> validUsers = new ArrayList<>(Collections.singletonList(user));
    Users users = new Users(validUsers);


    @Test
    public void returnsUserIsInDB() {
        assertTrue(users.isUserInUsersDB(user.getLoginNumber()));
    }

    @Test
    public void returnsUserIsNotInDB() {
        //assertFalse(users.isUserInUsersDB((invalidUser.getLoginNumber())));
        assertFalse(users.isUserInUsersDB("jkhdf"));
    }

    @Test
    public void getUserFromLoginNumber() {
        assertEquals(Optional.of(user), users.getUserFromLoginNumber("123-4567"));
    }


}