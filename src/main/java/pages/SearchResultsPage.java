package pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultsPage {
    private final ElementsCollection results = $$("[data-testid=\"result\"]");

    @Step("Check that results size is at least {expectedSize}")
    public void checkResultsSizeIsAtLeast(int expectedSize) {
        results.shouldHave(sizeGreaterThan(expectedSize));
    }

    @Step("Check that result with index {index} has text {expectedText}")
    public void checkResultHasTest(int index, String expectedText) {
        results.get(index).shouldHave(text(expectedText));
    }

    @Step("Open result with index {index}")
    public ElementsCollection getResults() {
        return results;
    }
}