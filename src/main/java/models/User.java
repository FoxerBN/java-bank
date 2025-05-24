package models;

public class User {
    private final int id;
    private final String name;
    private final String pin;
    private double balance;

    public User(int id, String name, String pin, double balance) {
        this.id = id;
        this.name = name;
        this.pin = pin;
        this.balance = balance;
    }

    public int getId() {return id;}
    public String getName() {return name;}
    public String getPin() {return pin;}
    public double getBalance() {return balance;}
    public void setBalance(double balance) {this.balance = balance;}
}
