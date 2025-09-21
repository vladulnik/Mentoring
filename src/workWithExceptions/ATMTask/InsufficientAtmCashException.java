package workWithExceptions.ATMTask;

public class InsufficientAtmCashException extends Exception{
    public InsufficientAtmCashException(String message) {
        super(message);
    }
}
