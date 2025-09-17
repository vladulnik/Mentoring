package workWithExceptions;

public class SafeMath {
    public static int safeMultiply(int a, int b) {
        try {
            long result = (long) a * b;
            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                throw new ArithmeticException("Incorrect size");
            }
            return (int) result;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
