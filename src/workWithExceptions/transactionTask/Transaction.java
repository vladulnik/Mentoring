package workWithExceptions.transactionTask;

public class Transaction {

    private final double amount;
    private final String accountId;
    private double accountBalance;

    public Transaction(double amount, String accountId, double accountBalance) {
        this.amount = amount;
        this.accountId = accountId;
        this.accountBalance = accountBalance;
    }

    public double getAmount() {
        return amount;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
