package com.vitsed.project.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    //Elements
    SelenideElement operationButton = $(byXpath(".//a[@title='Операции']"));
    SelenideElement listOfPeople = $(byText("Список лиц"));
    SelenideElement addButton = $x("//a[text()='Добавить']");
    SelenideElement addIndividual = $x("//a[text()='Добавить физическое лицо']");

    //Actions
    public void presOperationBtn() {
        operationButton.click();
    }

    public void pressAddIndividualBtn() {
        addIndividual.click();
    }

    public void pressAddBtn() {
        addButton.should(Condition.exist, Duration.ofSeconds(10)).click();
    }
}
