package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

class InputReader {

    int getUserNumber() {
        Scanner scanner = new Scanner(System.in);
        try {
            int userNumber = scanner.nextInt();
            if (isOutOfBounds(userNumber)) return -1;
            else return userNumber;
        } catch (InputMismatchException e) {
            System.out.println("That was not a number!");
        }
        return -1;
    }

    private boolean isOutOfBounds(int userNumber) {
        return (userNumber < 1 || userNumber > 6);
    }

    String getTitle() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    String getLoginNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    String getPassword() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
