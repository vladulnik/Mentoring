import Statick.Logger;
import Statick.ObjectCounter;

public class Main {
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance("DEBUG", "debug.log");
        Logger logger2 = Logger.getInstance("ERROR", "error.log");

        System.out.println(logger1 == logger2);
    }
}
