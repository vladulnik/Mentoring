package workWithConcurrency;

public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(double amount) {
        if(balance >= amount) {
            System.out.println(Thread.currentThread().getName() + "withdrawing " + amount);
            balance -= amount;
            System.out.println("Balance now: " + balance);
        }
        else
            System.out.println("No money: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}
