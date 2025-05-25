package controllers;

import models.User;
import services.UserService;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private final Scanner sc;
    private boolean isRunning;

    public MainController() {
        this.sc = new Scanner(System.in);
        this.isRunning = true;
    }

    public void start() {
        while (isRunning) {
            displayMenu();
            handleChoice();
        }
        sc.close();
    }

    private void displayMenu() {
        List<User> allUsers = UserService.getAllUsers();
        System.out.println("Users in database:");
        for (User user : allUsers) {
            System.out.println("- " + user.getName() + "- " + user.getBalance());
        }
        System.out.println("\n===Welcome to the Banking Application!===");
        System.out.println("1. Login");
        System.out.println("2. Deposit money");
        System.out.println("3. Withdraw money");
        System.out.println("4. Logout");
        System.out.println("5. Exit");
        System.out.println("Enter your choice:");
    }

    private void handleChoice() {
        try {
            int choice = sc.nextInt();
            sc.nextLine();

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
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            sc.nextLine();
        }
    }
}
