package ru.bulgakov.qa;

import org.junit.jupiter.api.Test;
import ru.bulgakov.git.repo.pages.GitWelcomePage;
import ru.bulgakov.pages.YandexSearchPage;
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

        //Configuration.holdBrowserOpen = true;

        open("https://github.com/", GitWelcomePage.class)
                .searchButtonClick()
                .setRepositoryName("java-automation-qa/getting-started")
                .clickOnRepositoryName()
                .checkUrlIsCorrect("java-automation-qa")
                .authorNameIsCorrect("Владислав Юстус");
    }
}


