package com.twu.biblioteca;

public class User {
    private String loginNumber;
    private String password;

    private String name;
    private String email;
    private String phoneNumber;

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

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
