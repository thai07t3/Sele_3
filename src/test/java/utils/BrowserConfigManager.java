package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BrowserConfigManager {
    private static final Properties properties = new Properties();

    static {
        try (FileInputStream input = new FileInputStream("src/test/resources/browser-config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load browser configuration", e);
        }
    }

    public static String getBrowserProperty(String browser, String key) {
        return properties.getProperty(browser + "." + key, "");
    }

    public static boolean getBrowserPropertyAsBoolean(String browser, String key) {
        return Boolean.parseBoolean(getBrowserProperty(browser, key));
    }
}
