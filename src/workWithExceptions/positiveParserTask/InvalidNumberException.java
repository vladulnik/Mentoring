package workWithExceptions.positiveParserTask;

public class InvalidNumberException extends Exception{
    public InvalidNumberException(String message) {
        super(message);
    }
}
