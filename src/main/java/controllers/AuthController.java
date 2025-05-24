package controllers;

import services.AuthService;

import java.util.Scanner;

public class AuthController {
    private static final Scanner sc = new Scanner(System.in);
    private static int loginAttempts = 3;

    public static void login() {
        while (loginAttempts > 0) {
            System.out.println("Please enter your PIN:");
            String pin = sc.nextLine();

            if (AuthService.login(pin)) {
                System.out.println("Login successful!");
                loginAttempts = 3;
                return;
            } else {
                loginAttempts--;
                System.out.println("Invalid PIN. Please try again.");
                System.out.println("You have " + loginAttempts + " attempts left.");

                if (loginAttempts == 0) System.exit(0);
            }
        }

    }

    public static void logout() {
        if (AuthService.getCurrentUser() == null) {
            System.out.println("You are not logged in.");
            return;
        }
        AuthService.logout();
        System.out.println("You have been logged out.");
    }
}