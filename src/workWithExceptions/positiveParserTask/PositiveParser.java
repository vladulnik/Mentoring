package workWithExceptions.positiveParserTask;

public class PositiveParser {
    public static int parsePositiveInt(String s) throws InvalidNumberException, NegativeNumberException {
        try {
            int value = Integer.parseInt(s);
            if(value <= 0) {
                throw new NegativeNumberException("Number must be positive");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("Not a valid integer");
        }
    }
}
