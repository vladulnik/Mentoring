package workWithExceptions.bankAccountTask;

import workWithExceptions.transactionTask.InsufficientFundsException;

public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Not enough money on account");
        }
        balance -= amount;
        System.out.println("Withdraw: " + amount + ". Balance left: " + balance);
    }

    public void deposit(double amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Amount must be more then 0");
        }
        balance += amount;
        System.out.println("Amount: " + amount + " added to your balance. Balance now: " + balance);
    }
}
