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
        } else {
            if(!instance.logLevel.equals(logLevel) || !instance.filePath.equals(filePath)) {
                System.out.println("Already exist");
            }
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
        System.out.println("[" + logLevel + "] (" + filePath + "): " + message);
    }

    public void updateConfig(String logLevel, String filePath) {
        this.logLevel = logLevel;
        this.filePath = filePath;
        System.out.println("Configuration updated");
    }
}
