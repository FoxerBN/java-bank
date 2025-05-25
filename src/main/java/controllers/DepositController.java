package controllers;

import services.AuthService;
import services.BankService;
import javax.swing.*;

import static controllers.AuthController.frame;

public class DepositController {
    public static void deposit() {
        if (AuthService.getCurrentUser() == null) {
            JOptionPane.showMessageDialog(frame, "You must be logged in to deposit money.");
            return;
        }
        String input = JOptionPane.showInputDialog("Enter the amount you want to deposit:");
        if (input == null) return;
        try {
            double amount = Double.parseDouble(input);
            if (BankService.deposit(amount)) {
                JOptionPane.showMessageDialog(frame, String.format(
                        "Successfully deposited %.2f. New balance: %.2f.",
                        amount, AuthService.getCurrentUser().getBalance()));
            } else {
                JOptionPane.showMessageDialog(frame, "Deposit failed. Please try again.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid amount.");
        }
    }
}