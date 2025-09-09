package Statick;

public class Logger {

    private static Logger instance;

    private String logLevel;
    private String filePath;

    private Logger(String logLevel, String filePath) {
        this.logLevel = logLevel;
        this.filePath = filePath;
    }

    public static Logger getInstance(String logLevel, String filePath) {
        if(instance == null) {
            instance = new Logger(logLevel, filePath);
        }
        return instance;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public String getFilePath() {
        return filePath;
    }

    public void log(String message) {
        System.out.println("[" + this.logLevel + "] (" + this.filePath + "): " + message);
    }
}
