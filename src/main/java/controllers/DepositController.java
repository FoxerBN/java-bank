package controllers;

import services.AuthService;
import services.BankService;
import java.util.Scanner;

public class DepositController {
    private static final Scanner sc = new Scanner(System.in);

    public static void deposit(){
        if(AuthService.getCurrentUser() == null){
            System.out.println("You must be logged in to deposit money.");
            return;
        }

        System.out.println("Enter the amount you want to deposit:");
        double amount = sc.nextDouble();
        sc.nextLine();

        if(BankService.deposit(amount)){
            System.out.printf("Successfully deposited %.2f. Your new balance is %.2f.%n",
                              amount, AuthService.getCurrentUser().getBalance());
        }else {
            System.out.println("Deposit failed. Please try again.");
        }
    }
}
