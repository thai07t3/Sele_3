package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BrowserFactory {

    public static WebDriver createDriver(String browser) {
        WebDriver driver;
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/browser-config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String windowSize = properties.getProperty(browser + ".windowSize", "1920,1080");
        boolean disablePopupBlocking = Boolean.parseBoolean(properties.getProperty(browser + ".disablePopupBlocking", "true"));

        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--width=" + windowSize.split(",")[0]);
                firefoxOptions.addArguments("--height=" + windowSize.split(",")[1]);
                if (disablePopupBlocking) {
                    firefoxOptions.addArguments("--disable-popup-blocking");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--window-size=" + windowSize);
                if (disablePopupBlocking) {
                    chromeOptions.addArguments("--disable-popup-blocking");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
        }

        return driver;
    }
}