package workWithExceptions;

public class TransactionProcessor {

    private static final Logger logger = Logger.getLogger(TransactionProcessor.class);

    public void processTransaction(Transaction transaction)
            throws ValidationException, InsufficientFundsException {

        try {
            validateTransaction(transaction);
            processPayment(transaction);
            completeTransaction(transaction);
        } catch (ValidationException e) {
            logger.warning("Validation error: " + e.getMessage());
            throw e;
        } catch (InsufficientFundsException e) {
            logger.severe("Insufficient funds: " + e.getMessage());
            rollbackTransaction(transaction);
            throw e;
        } catch (Exception e) {
            logger.error("Unknown error: " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    private void validateTransaction(Transaction t) throws ValidationException {
        if(t.getAmount() <= 0) {
            throw new ValidationException("Incorrect transaction sum");
        }
    }

    private void processPayment(Transaction t) throws InsufficientFundsException {
        if (t.getAccountBalance() < t.getAmount()) {
            throw new InsufficientFundsException("Insufficient funds in the account");
        }
        t.setAccountBalance(t.getAccountBalance() - t.getAmount());
        logger.info("Payment has been successfully completed for the amount: " + t.getAmount());
    }

    private void completeTransaction(Transaction t) {
        logger.info("Transaction completed: " + t.getAccountId());
    }

    private void rollbackTransaction(Transaction t) {
        logger.warning("Transaction canceled: " + t.getAccountId());
    }
}
