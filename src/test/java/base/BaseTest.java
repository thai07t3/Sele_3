package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.*;

public class BaseTest {

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        // Lấy browser từ tham số testng.xml
        Configuration.browser = browser;
        Configuration.browserSize = ("true");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
