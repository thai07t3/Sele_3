package base;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.BrowserFactory;

public class BaseTest {

    private WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        String browserFromMaven = System.getProperty("browser");
        if (browserFromMaven != null && !browserFromMaven.isEmpty()) {
            browser = browserFromMaven;
        }
        driver = BrowserFactory.createDriver(browser);
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
