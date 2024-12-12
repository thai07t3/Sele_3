package tests;

import static com.codeborne.selenide.Selenide.*;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.GooglePage;
import pages.SearchResultsPage;

public class GoogleTest extends BaseTest {

    @Test
    public void userCanSearch() {
        open("https://google.com/");
        new GooglePage().searchFor("selenide java");

        SearchResultsPage results = new SearchResultsPage();
        results.checkResultsSizeIsAtLeast(1);
        results.checkResultHasTest(0, "Selenide: concise UI tests in Java");
    }
}
