package com.twu.biblioteca;

import java.util.Scanner;

public class InputReader {

    int getUserNumber() {
        Scanner scanner = new Scanner(System.in);
        int userNumber = scanner.nextInt();
        if (isOutOfBounds(userNumber)) return -1;
        else return userNumber;
    }

    private boolean isOutOfBounds(int userNumber) {
        return (userNumber < 1 || userNumber > 4);
    }

    String getBookTitle() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
