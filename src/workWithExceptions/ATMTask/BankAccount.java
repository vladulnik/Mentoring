package workWithExceptions.ATMTask;

public class BankAccount {

    private double balance;
    private String pin;
    private double dailyLimit;
    private double withdrawnToday;

    public BankAccount(double balance, String pin, double dailyLimit, double withdrawnToday) {
        this.balance = balance;
        this.pin = pin;
        this.dailyLimit = dailyLimit;
        this.withdrawnToday = withdrawnToday;
    }

    public void withdraw(double amount) throws InsufficientBalanceException, IllegalArgumentException {
        if (amount <= 0) {
            throw new InsufficientBalanceException("No money on account");
        }
        if (dailyLimit < withdrawnToday + amount) {
            throw new IllegalArgumentException("Daily limit exceeded");
        }
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("deposit");
    }

    public double getBalance() {
        return balance;
    }

    public boolean checkPin(String pin) {
        return this.pin.equals(pin);
    }
}
