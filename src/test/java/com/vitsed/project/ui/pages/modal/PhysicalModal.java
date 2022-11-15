package com.vitsed.project.ui.pages.modal;

import com.codeborne.selenide.SelenideElement;
import com.vitsed.project.ui.pages.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PhysicalModal extends AbstractPage {

    SelenideElement window = $(By.id("physicalPersonEditForm"));
    SelenideElement modalBirthPlace = $x("div[@role='dialog'][.//h4[text()='Место рождения']");

    SelenideElement inputFirstName = $(By.cssSelector("div[selectedobject='person.Firstname']>div>input"));

    SelenideElement inputLastName = $("div[selectedobject='person.Surname']>div>input");

    SelenideElement inputPersonInn = $("input[ng-model='person.Inn']");
    SelenideElement inputPersonBirthday = $("input[ng-model='person.BirthDate']");
    SelenideElement choosePersonSex = $x("//*[@property-name='person.Sex']/div");
    SelenideElement choosePersonCitizenship = $x("//*[@property-name='person.Citizenship_Id']/div");
    SelenideElement inputBirthPlace = $("*[field-name='person.Birthplace'] > div > input");
    SelenideElement inputRegistrationAddress = $("address-control[field-var='person.FullAddress'] > div > input");

    @Step("Ввести имя")
    public void inputFirstName(String firstName) {
        inputFirstName.setValue(firstName);
        makeScreenshot();
    }

    @Step("Ввести фамилию")
    public void inputLastName(String lastName) {
        inputLastName.setValue(lastName);
        makeScreenshot();
    }

    @Step("Ввести ИНН")
    public void inputPersonInn(String inn) {
        inputPersonInn.setValue(inn);
        makeScreenshot();
    }

    @Step("Ввести день рождения")
    public void inputBirthday(String birthday) {
        inputPersonBirthday.setValue(birthday).pressEnter();
        makeScreenshot();
    }

    @Step("Выбрать пол")
    public void choosePersonSex(String sex) {
        choosePersonSex.click();
        SelenideElement input = choosePersonSex.$("div input");
        input.shouldBe(visible).sendKeys(sex);
        input.pressEnter();
        makeScreenshot();
    }

    @Step("Ввести гражданство")
    public void choosePersonCitizenship(String citizenship) {
        choosePersonCitizenship.click();
        SelenideElement input = choosePersonCitizenship.$("div input");
        input.shouldBe(visible).sendKeys(citizenship);
        input.pressEnter();
        makeScreenshot();
    }

    @Step("Выбрать место рождения")
    public void setBirthPlace(String text) {
        inputBirthPlace.click();
        SelenideElement ta = $("textarea[ng-model='address']");
        ta.sendKeys(text);
        $x("//button[text()='OK']").click();
        makeScreenshot();
    }

    public void enterRegistrationAddress() {
        inputRegistrationAddress.click();
    }
}
