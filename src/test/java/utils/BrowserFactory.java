package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {

    public static WebDriver createDriver(String browser) {
        String gridUrl = BrowserConfigManager.getBrowserProperty(browser, "gridUrl");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Config base on browser
        capabilities.setBrowserName(BrowserConfigManager.getBrowserProperty(browser, "browser"));

        try {
            if (!gridUrl.isEmpty()) {
                // Use RemoteWebDriver if gridUrl is not null
                return new RemoteWebDriver(new URL(gridUrl), capabilities);
            } else {
                // Generate WebDriver local if girUrl is null
                switch (browser.toLowerCase()) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        return new ChromeDriver();
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        return new FirefoxDriver();
                    case "edge":
                        WebDriverManager.edgedriver().setup();
                        return new EdgeDriver();
                    case "safari":
                        WebDriverManager.safaridriver().setup();
                        return new SafariDriver();
                    case "ie":
                        WebDriverManager.iedriver().setup();
                        return new EdgeDriver();
                    default:
                        throw new RuntimeException("Unsupported browser: " + browser);
                }
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid grid URL for browser: " + browser, e);
        }
    }
}
