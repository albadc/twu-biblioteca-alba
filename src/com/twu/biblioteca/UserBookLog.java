package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.HashMap;

class UserBookLog {
    HashMap<User, ArrayList<Book>> userBookLog = new HashMap<>();

    void addUserToLog(User user) {
        if (!isUserInLog(user)) {
            userBookLog.put(user, new ArrayList<>());
        }
    }

    boolean isUserInLog(User user) {
        return userBookLog.containsKey(user);
    }

    void addBookToLog(User user, Book book) {
        userBookLog.computeIfAbsent(user, b -> new ArrayList<>()).add(book);

    }


    boolean hasUserCheckedOutBook(User user, Book book) {
        return userBookLog.getOrDefault(user, new ArrayList<>()).contains(book);
    }

    void removeBookFromLog(User user, Book book) {
        userBookLog.get(user).remove(book);
    }
}
