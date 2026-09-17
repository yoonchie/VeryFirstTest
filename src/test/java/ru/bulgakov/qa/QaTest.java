package ru.bulgakov.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.bidi.script.LocalValue.setValue;

public class QaTest {

    @Test
    void priceShouldBe47000Test(){
        /* Тест-кейс - провермть, что предоплата по обучению 47000 рублей
        * 1 открыть хром
        * 2 ввести данные сайтв
        * 3 нажать поиск
        * 4 в поисковой выдаче найти сайт, кликнуть на него
        * 5 нажать на кнопку "стоимость"
        * 6 нажать на кнопку "хочу вкатиться в qa"
        * 7 нажать "бегу оплачивать"
        * 8 проверить, что к оплате 47 000 рублей
        * */

        //Configuration.holdBrowserOpen = true;

        open("https://ya.ru/");
        $("#text").setValue("bulgakov qa");
        $("[type=submit]").click();//но проще .pressEnter();
       // $(".DistributionButtonClose").click();
        $(byText ("ivanbulgakovqa.ru")).click();

        sleep(3000);
        switchTo().window(1);
        //System.out.println($$(".t-menu__list li").size());
        $$(".t-menu__list li").last().click();
        $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a").click();
        $(byText("Бегу оплачивать")).click();

        sleep(3000);
        switchTo().window(2);
        sleep(8000); //оочень долго грузилась страница и тест падал как failed, с этим проходит
        $x("/html/body/div[2]/div/div/main/div/div/div[2]/aside/div[1]/div/div/span/div[1]/div/h3").shouldHave(text("₽ 47 000.00")); //уникальные селекторы для этой строки - все
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

        Configuration.holdBrowserOpen = true;

        open("https://github.com/");
        $("button[aria-label='Search or jump to, type / to search']").click();
        $("[role='combobox']").setValue("java-automation-qa/getting-started").pressEnter();
        $$("a[href*='/java-automation-qa/getting-started']").get(0).click();
        $(".url").shouldHave(text("java-automation-qa"));
        $$(".AuthorLink-module__authorLinkContainer__RsptC").first().shouldBe(text("Владислав Юстус"));
    }
}


