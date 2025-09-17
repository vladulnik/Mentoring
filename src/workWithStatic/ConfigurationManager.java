package workWithStatic;

public class ConfigurationManager {

    private static ConfigurationManager instance;

    private String appName;
    private String version;
    private String author;

    private ConfigurationManager(String appName, String version, String author) {
        this.appName = appName;
        this.version = version;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public String getVersion() {
        return version;
    }

    public String getAppName() {
        return appName;
    }

    public static ConfigurationManager getInstance(String appName, String version, String author) {
        if (instance == null) {
            instance = new ConfigurationManager(appName, version, author);
        } else {
            if (!instance.appName.equals(appName) || !instance.version.equals(version) || !instance.author.equals(author)) {
                throw new IllegalStateException("Already exist");
            }
        }
        return instance;
    }

    public void printConfig() {
        System.out.println("App: " + appName + "\nVersion: " + version + "\nAuthor: " + author);
    }

    public void updateConfig(String appName, String version, String author) {
        this.appName = appName;
        this.version = version;
        this.author = author;
        System.out.println("Configuration updated");
    }
}
