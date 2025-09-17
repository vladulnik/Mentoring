package workWithExceptions.transactionTask;

public class main {
    public static void main(String[] args) {
        Transaction transaction = new Transaction(200, "12321314", 2000);

        try {
            TransactionProcessor.processTransaction(transaction);
        } catch (ValidationException | InsufficientFundsException e) {
            throw new RuntimeException(e);
        }
    }
}
