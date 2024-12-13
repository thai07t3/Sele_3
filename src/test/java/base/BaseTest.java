package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.BrowserFactory;

@Listeners(utils.TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void setup() {
        String browser = System.getProperty("browser", "chrome");
        driver = BrowserFactory.createDriver(browser);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}