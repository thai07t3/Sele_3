package pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GooglePage {
    private SelenideElement searchField = $(byName("q"));

    @Step("Search for {text}")
    public void searchFor(String text) {
        searchField.val(text).pressEnter();
    }
}