package workWithExceptions.simpleTasks;

public class SafeDivider {

    public static int safeDivide(int a, int b) {
        try {
            if(b == 0) {
                throw new ArithmeticException("Second number is 0");
            }
            long result = (long) a / b;
            if(result >= Integer.MAX_VALUE || result <= Integer.MIN_VALUE){
                throw new ArithmeticException("Incorrect size");
            }
            return (int) result;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
