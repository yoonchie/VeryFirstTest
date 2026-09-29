package ru.bulgakov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class YandexSearchResultPage {
    private final SelenideElement closeWindow = $(".DistributionButtonClose");

    public YandexSearchResultPage closeDefaultBrowser() {
        closeWindow.click();

        return this;
    }

    public AboutStudyPage openLink(String webSiteName) {
        $$("a")
                .findBy(text(webSiteName))
                .click();

        switchTo().window(1);

        return new AboutStudyPage();
    }
}
