# Sele_3
Build a framework with Selenide

## Project Overview
This project is a test automation framework built using Selenide, a powerful library for browser automation in Java. The framework is designed to run tests in parallel across multiple browsers and generate detailed test reports using Allure and the default TestNG/JUnit reporting mechanisms.

## Prerequisites
- Java 11 or higher
- Maven 3.6.3 or higher
- Allure Commandline (for generating Allure reports)
- WebDriver binaries managed by WebDriverManager

## Project Structure
- `src/main/java`: Contains the main Java source code.
- `src/test/java`: Contains the test classes.
- `src/test/resources`: Contains the test resources, including the `browser-config.properties` file for browser configurations.
- `target/surefire-reports`: Contains the default TestNG/JUnit test reports.
- `allure-results`: Contains the Allure test results.

## Configuration
### Browser Configuration
Browser settings can be configured in the `src/test/resources/browser-config.properties` file. Example:
```ini
# Chrome
chrome.browser=chrome
chrome.headless=true
chrome.gridUrl=
chrome.windowSize=1920,1080
chrome.disablePopupBlocking=true

# Firefox
firefox.browser=firefox
firefox.headless=false
firefox.gridUrl=
firefox.windowSize=1920,1080
firefox.disablePopupBlocking=true