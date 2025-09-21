package workWithExceptions.ATMTask;

public class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}
