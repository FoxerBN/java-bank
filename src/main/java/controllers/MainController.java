package controllers;

import models.User;
import services.UserService;

import javax.swing.*;
import java.util.List;

public class MainController {
    private boolean isRunning;

    public MainController() {
        this.isRunning = true;
    }

    public void start() {
        while (isRunning) {
            String input = displayMenu();
            handleChoice(input);
        }
    }

    private String displayMenu() {
        List<User> allUsers = UserService.getAllUsers();
        StringBuilder sb = new StringBuilder("Users in database:\n");
        for (User user : allUsers) {
            sb.append("- ").append(user.getName()).append(" - ").append(user.getBalance()).append("\n");
        }
        sb.append("\n===Welcome to the Banking Application===\n")
                .append("1. Login\n")
                .append("2. Deposit money\n")
                .append("3. Withdraw money\n")
                .append("4. Logout\n")
                .append("5. Exit\n");
        return JOptionPane.showInputDialog(null, sb.toString() + "\nEnter your choice:");
    }

    private void handleChoice(String input) {
        if (input == null) return;
        try {
            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    AuthController.login();
                    break;
                case 2:
                    DepositController.deposit();
                    break;
                case 3:
                    WithdrawController.withdraw();
                    break;
                case 4:
                    AuthController.logout();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Thank you for using the Banking Application!");
                    isRunning = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }
    }
}