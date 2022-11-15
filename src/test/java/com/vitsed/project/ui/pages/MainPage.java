package com.vitsed.project.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends AbstractPage {

    SelenideElement operationButton = $(byXpath(".//a[@title='Операции']"));
    SelenideElement listOfPeople = $(byText("Список лиц"));
    SelenideElement addButton = $x("//a[text()='Добавить']");
    SelenideElement addIndividual = $x("//a[text()='Добавить физическое лицо']");

    public void presOperationBtn() {
        operationButton.click();
    }

    @Step("Нажать кнопку 'Добавить физ.лицо'")
    public void pressAddIndividualBtn() {
        addIndividual.shouldBe(visible, Duration.ofSeconds(5)).click();
        makeScreenshot();
    }

    @Step("Нажать кнопку 'Добавить'")
    public void pressAddBtn() {
        addButton.should(exist, Duration.ofSeconds(10)).click();
        makeScreenshot();
    }
}
