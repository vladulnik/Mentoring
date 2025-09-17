package workWithExceptions;

public class SafeCalculator {
    public static int divide(int a, int b) {
        try {
            if(b == 0) {
                throw new ArithmeticException("Cant be divided by 0");
            }
            long result = (long) a / b;
            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                throw new ArithmeticException("Incorrect size");
            }
            return (int)result;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
