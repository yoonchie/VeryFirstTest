package ru.bulgakov.qa;

import org.junit.jupiter.api.Test;
import ru.bulgakov.pages.YandexSearchPage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class QaTest {

    @Test
    void priceShouldBe47000Test(){
        //Configuration.holdBrowserOpen = true;

        open("https://ya.ru/", YandexSearchPage.class)
                .search("bulgakov qa")
                .submit()
                //.closeDefaultBrowser()
                .openLink("ivanbulgakovqa.ru")
                .clickPrice()
                .findCurrentPrice()
                .letsPay()
                .sleep(20000)
                .thePriceIsCorrect("₽ 47 000.00");
    }

    @Test
    void findRepositoryOnGitHub(){

        /*Открыть GitHub.
    1. Найти поле поиска и ввести: java-automation-qa/getting-started
    2. Нажать Enter
    3. На странице результатов найти коллекцию и внутри нее выбрать элемент для перехода в сам репозиторий
    4. Перейти в репозиторий
    5. Проверить название репозитория
    8. проверить владельца этого репозитория (получилось тоже через коллекцию);
    */

        //Configuration.holdBrowserOpen = true;

        open("https://github.com/");
        $("button[aria-label='Search or jump to, type / to search']").click();
        $("[role='combobox']").setValue("java-automation-qa/getting-started").pressEnter();
        $$("a[href*='/java-automation-qa/getting-started']").get(0).click();
        $(".url").shouldHave(text("java-automation-qa"));
        $$(".AuthorLink-module__authorLinkContainer__RsptC").first().shouldBe(text("Владислав Юстус"));
    }
}


