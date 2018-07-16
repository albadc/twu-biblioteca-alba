package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Optional;

public class Users {
    private ArrayList<User> users;

    Users(ArrayList<User> users) {
        this.users = users;
    }

    boolean isUserInUsersDB(String loginNumber) {
        return users.stream().anyMatch(user -> loginNumber.equals(user.getLoginNumber()));
    }

    Optional<User> getUserFromLoginNumber(String loginNumber) {
        return users.stream().filter(user -> loginNumber.equals(user.getLoginNumber())).findFirst();
    }
}
