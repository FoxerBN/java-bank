package controllers;

import services.AuthService;
import services.BankService;
import javax.swing.*;

import static controllers.AuthController.frame;

public class WithdrawController {
    public static void withdraw() {
        if (AuthService.getCurrentUser() == null) {
            JOptionPane.showMessageDialog(frame, "You must be logged in to withdraw money.");
            return;
        }
        String input = JOptionPane.showInputDialog("Enter the amount you want to withdraw:");
        if (input == null) return;
        try {
            double amount = Double.parseDouble(input);
            if (BankService.withdraw(amount)) {
                JOptionPane.showMessageDialog(frame, String.format(
                        "Successfully withdrew %.2f. New balance: %.2f.",
                        amount, AuthService.getCurrentUser().getBalance()));
            } else {
                JOptionPane.showMessageDialog(frame, "Withdraw failed. Please try again.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid amount.");
        }
    }
}