package ru.bulgakov.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PaymentPage {
    private final SelenideElement payMoney = $(byText("Бегу оплачивать"));
    private final SelenideElement price = $x("/html/body/div[2]/div/div/main/div/div/div[2]/aside/div[1]/div/div/span/div[1]/div/h3");

    public PaymentPage letsPay(){
        payMoney.click();

        switchTo().window(2);

        return this;
    }

    public PaymentPage sleep(int milliseconds) {
        Selenide.sleep(milliseconds);

        return this;
    }

    public void thePriceIsCorrect(String query){
        price.shouldHave(text(query));
    }

}
