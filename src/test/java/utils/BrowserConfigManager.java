package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BrowserConfigManager {
    private static Properties properties = new Properties();

    static {
        try (FileInputStream input = new FileInputStream("src/test/resources/browser-config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load browser configuration", e);
        }
    }

    public static String get(String browser, String key) {
        return properties.getProperty(browser + "." + key);
    }
}
