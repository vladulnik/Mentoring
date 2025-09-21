package workWithExceptions.ATMTask;

import workWithExceptions.ATMTask.BankAccount;

public class ATM {

    private double cashInside;
    private BankAccount currentAccount;
    private boolean authenticated;
    private int pinAttemptsLeft = 3;

    public ATM(double cashInside) {
        this.cashInside = cashInside;
    }

    public void insertCart(BankAccount account) throws IllegalStateException {
        if (currentAccount != null) throw new IllegalStateException("Card already inserted");
        currentAccount = account;
        authenticated = false;
        pinAttemptsLeft = 3;
    }

    public void enterPin(String pin) throws CardNotInsertedException, InvalidPinException {
        ensureCardInserted();
        if (currentAccount.checkPin(pin)) {
            authenticated = true;
            return;
        }
        pinAttemptsLeft--;
        if (pinAttemptsLeft <= 0) {
            currentAccount = null;
            authenticated = false;
            throw new InvalidPinException("PIN blocked");
        }
        throw new InvalidPinException("Invalid PIN: " + pinAttemptsLeft);
    }

    public double balance() throws CardNotInsertedException, InvalidPinException {
        ensureReady();
        return currentAccount.getBalance();
    }

    public void withdrawCash(double amount) throws CardNotInsertedException, InvalidPinException, InsufficientBalanceException, InsufficientAtmCashException {
        ensureReady();
        if(amount > cashInside) throw new InsufficientAtmCashException("ATM out of cash");
        currentAccount.withdraw(amount);
        cashInside -= amount;
    }

    public void ejectCard() {
        currentAccount = null;
        authenticated = false;
        pinAttemptsLeft = 3;
    }

    private void ensureCardInserted() throws CardNotInsertedException {
        if(currentAccount == null) throw new CardNotInsertedException("Insert card first");
    }

    private void ensureReady() throws CardNotInsertedException, InvalidPinException {
        ensureCardInserted();
        if(!authenticated) throw new InvalidPinException("Not authenticated");
    }
}
