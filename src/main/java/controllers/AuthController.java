package controllers;

import services.AuthService;

import javax.swing.*;
import java.awt.*;

public class AuthController {
    private static int loginAttempts = 3;
    static Component frame;

    public static void login() {
        while (loginAttempts > 0) {
            String pin = JOptionPane.showInputDialog(frame, "Please enter your PIN:");

            if (AuthService.login(pin)) {
                JOptionPane.showMessageDialog(frame, "Login successful!");
                loginAttempts = 3;
                return;
            } else {
                loginAttempts--;
                JOptionPane.showMessageDialog(frame, "Invalid PIN. Attempts left: " + loginAttempts);

                if (loginAttempts == 0) System.exit(0);
            }
        }

    }

    public static void logout() {
        if (AuthService.getCurrentUser() == null) {
            JOptionPane.showMessageDialog(frame, "You are not logged in.");
            return;
        }
        AuthService.logout();
        JOptionPane.showMessageDialog(frame, "You have been logged out successfully.");
    }
}