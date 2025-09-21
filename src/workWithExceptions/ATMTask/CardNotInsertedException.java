package workWithExceptions.ATMTask;

public class CardNotInsertedException extends Exception{
    public CardNotInsertedException(String message) {
        super(message);
    }
}
