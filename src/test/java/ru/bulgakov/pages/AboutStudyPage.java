package ru.bulgakov.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

public class AboutStudyPage {
    private final ElementsCollection price = $$(".t-menu__list li");
    private final SelenideElement currentPrice = $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a");

    public AboutStudyPage clickPrice(){
        price.shouldHave(sizeGreaterThan(0));
        price.last().click();

        return this;
    }

    public PaymentPage findCurrentPrice(){
        currentPrice.click();

        return new PaymentPage();
    }

}
