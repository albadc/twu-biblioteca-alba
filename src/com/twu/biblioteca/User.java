package com.twu.biblioteca;

public class User {
    private String loginNumber;
    private String password;

    User(String loginNumber, String password) {
        this.loginNumber = loginNumber;
        this.password = password;
    }

    String getLoginNumber() {
        return loginNumber;
    }

    boolean logIn(String number, String pass) {
        return this.loginNumber.equals(number) && this.password.equals(pass);
    }

}
