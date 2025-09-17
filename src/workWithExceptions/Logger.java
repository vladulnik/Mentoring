package workWithExceptions;

public class Logger {

    private String className;

    private Logger(Class<?> clazz) {
        this.className = clazz.getSimpleName();
    }

    public static Logger getLogger(Class<?> clazz) {
        return new Logger(clazz);
    }

    public void info(String message) {
        System.out.println("[INFO] [" + className + "] " + message);
    }

    public void warning(String message) {
        System.out.println("[WARNING] [" + className + "] " + message);
    }

    public void severe(String message) {
        System.err.println("[SEVERE] [" + className + "] " + message);
    }

    public void error(String message) {
        System.err.println("[ERROR] [" + className + "] " + message);
    }
}

