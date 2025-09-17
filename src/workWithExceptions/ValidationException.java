package workWithExceptions;

import workWithClones.Engine;

public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}
