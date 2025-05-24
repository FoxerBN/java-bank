package controllers;

import services.BankService;
import services.AuthService;
import java.util.Scanner;

public class WithdrawController {
    private static final Scanner sc = new Scanner(System.in);

    public static void withdraw(){
        if(AuthService.getCurrentUser() == null) {
            System.out.println("You must be logged in to withdraw money.");
            return;
        }

        System.out.println("Enter the amount you want to withdraw:");
        double amount = sc.nextDouble();
        sc.nextLine();

        if(amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
            return;
        }

        if(BankService.withdraw(amount)) {
            System.out.printf("Successfully withdrew %.2f. Your new balance is %.2f.%n",
                              amount, AuthService.getCurrentUser().getBalance());
        } else {
            System.out.println("Withdrawal failed. Please check your balance and try again.");
        }
    }

}
