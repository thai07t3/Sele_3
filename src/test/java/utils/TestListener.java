package utils;

import base.BaseTest;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.reporters.TestHTMLReporter;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();
        if (driver != null) {
            saveScreenshot(driver);
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onStart(ITestContext context) {
        String reportType = System.getProperty("report", "allure");
        switch (reportType) {
            case "html":
                TestHTMLReporter reporter = new TestHTMLReporter();
                break;
            case "report-portal":
                // Initialize Report Portal
                break;
            case "allure":
            default:
                AllureTestNg allure = new AllureTestNg();
                break;
        }
    }

    // Other overridden methods can be left empty
}