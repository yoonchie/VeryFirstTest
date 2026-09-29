package ru.bulgakov.git.repo.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GitWelcomePage {

    private final SelenideElement search = $("button[aria-label='Search or jump to, type / to search']");
    private final SelenideElement addText = $("[role='combobox']");
    private final ElementsCollection repoName = $$("a[href*='/java-automation-qa/getting-started']");
    private final SelenideElement url = $(".url");
    private final ElementsCollection authorLink = $$(".AuthorLink-module__authorLinkContainer__RsptC");

    public GitWelcomePage searchButtonClick(){
        search.click();

        return this;
    }

    public GitWelcomePage setRepositoryName(String query){
        addText.setValue(query).pressEnter();

        return this;
    }

    public GitWelcomePage clickOnRepositoryName(){
        repoName.get(0).click();

        return this;
    }

    public GitWelcomePage checkUrlIsCorrect(String query){
        url.shouldHave(text(query));

        return this;

    }

    public void authorNameIsCorrect(String query){
        authorLink.first().shouldHave(text(query));
    }

}
