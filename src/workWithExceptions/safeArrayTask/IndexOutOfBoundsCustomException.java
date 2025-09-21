package workWithExceptions.safeArrayTask;

public class IndexOutOfBoundsCustomException extends Exception{
    public IndexOutOfBoundsCustomException(String message) {
        super(message);
    }
}
