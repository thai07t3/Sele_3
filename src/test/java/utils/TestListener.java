package utils;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.ITestListener;
import org.testng.ITestResult;
import io.qameta.allure.Allure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Files;

public class TestListener implements ITestListener {

    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Override
//    public void onTestFailure(ITestResult result) {
//        logger.error("Test case failed: {}", result.getName());
//
//        // Attempt to scroll to the failed element if available
//        try {
//            WebElement failedElement = getFailedElement(); // Custom method to get element causing failure
//            if (failedElement != null) {
//                Selenide.executeJavaScript("arguments[0].scrollIntoView(true);", failedElement);
//                logger.info("Scrolled to failed element.");
//            }
//        } catch (Exception e) {
//            logger.error("Could not scroll to element: {}", e.getMessage());
//        }
//
//        // Capture screenshot and attach to Allure report
//        try {
//            byte[] screenshot = Selenide.screenshot(OutputType.BYTES);
//            if (screenshot != null) {
//                Allure.getLifecycle().addAttachment(
//                        "Failure Screenshot",
//                        "image/png",
//                        "png",
//                        screenshot
//                );
//                logger.info("Screenshot attached to Allure report.");
//            }
//        } catch (Exception e) {
//            logger.error("Failed to capture or attach screenshot: {}", e.getMessage());
//        }
//    }

    public void onTestFailure(ITestResult result) {
        logger.error("Test case failed: {}", result.getName());

        // Attempt to scroll to the failed element if available
        try {
            WebElement failedElement = getFailedElement(); // Custom method to get element causing failure
            if (failedElement != null) {
                Selenide.executeJavaScript("arguments[0].scrollIntoView(true);", failedElement);
                logger.info("Scrolled to failed element.");
            }
        } catch (Exception e) {
            logger.error("Could not scroll to element: {}", e.getMessage());
        }

        // Capture screenshot and attach to Allure report
        try {
            // Capture screenshot as file
            File screenshot = Selenide.screenshot(OutputType.FILE);

            // Read the screenshot as bytes
            if (screenshot != null && screenshot.exists()) {
                byte[] screenshotBytes = Files.readAllBytes(screenshot.toPath());
                Allure.getLifecycle().addAttachment(
                        "Failure Screenshot",
                        "image/png",
                        "png",
                        screenshotBytes
                );
                logger.info("Screenshot attached to Allure report.");
            } else {
                logger.error("Screenshot file not found.");
            }
        } catch (Exception e) {
            logger.error("Failed to capture or attach screenshot: {}", e.getMessage());
        }
    }

    private WebElement getFailedElement() {
        // Logic to retrieve the element that caused the failure
        // This can be implemented based on your custom assertion or test logic
        return null;
    }
}
