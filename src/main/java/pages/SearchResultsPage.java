package pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultsPage {
    private final ElementsCollection results = $$("[data-testid=\"result\"]");

    public void checkResultsSizeIsAtLeast(int expectedSize) {
        results.shouldHave(sizeGreaterThan(expectedSize));
    }

    public void checkResultHasTest(int index, String expectedText) {
        results.get(index).shouldHave(text(expectedText));
    }

    public ElementsCollection getResults() {
        return results;
    }
}