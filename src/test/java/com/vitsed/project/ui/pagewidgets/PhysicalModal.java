package com.vitsed.project.ui.pagewidgets;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PhysicalModal {

    //Elements
    SelenideElement window = $(By.id("physicalPersonEditForm"));
    SelenideElement modalBirthPlace = $x("div[@role='dialog'][.//h4[text()='Место рождения']");
//    Обязательными полями для заполнения физического лица являются:
//    Фамилия;
//    Имя;
//    Пол;
//    Дата рождения;
//    ИНН;
//    Гражданство;
//    Место рождения;
//    Место регистрации.

    SelenideElement inputFirstName = $(By.cssSelector("div[selectedobject='person.Firstname']>div>input"));
    //Actions
    SelenideElement inputLastName = $(By.cssSelector("div[selectedobject='person.Surname']>div>input"));

    SelenideElement inputPersonInn = $("input[ng-model='person.Inn']");
    SelenideElement inputPersonBirthday = $("input[ng-model='person.BirthDate']");
    SelenideElement choosePersonSex = $x("//*[@property-name='person.Sex']/div");
    SelenideElement choosePersonCitizenship = $x("//*[@property-name='person.Citizenship_Id']/div");
    SelenideElement inputBirthPlace = $("*[field-name='person.Birthplace'] > div > input");
    public void inputFirstName(String firstName) {
        inputFirstName.setValue(firstName);
    }

    public void inputLastName(String lastName) {
        inputLastName.setValue(lastName);
    }

    public void inputPersonInn(String inn) {
        inputPersonInn.setValue(inn);
    }

    public void inputBirthday(String birthday) {
        inputPersonBirthday.sendKeys(birthday);
        inputPersonBirthday.pressEnter();
    }

    public void choosePersonSex(String sex) {
        // select option doesn't work correctly cuz instead of value is using label also select tag invisible
        choosePersonSex.click();
        SelenideElement input = choosePersonSex.$("div").$("input");
        input.shouldBe(visible).sendKeys(sex);
        input.pressEnter();
    }

    public void choosePersonCitizenship(String citizenship) {
        // select option doesn't work correctly cuz instead of value is using label also select tag invisible
        choosePersonCitizenship.click();
        SelenideElement input = choosePersonCitizenship.$("div").$("input");
        input.shouldBe(visible).sendKeys(citizenship);
        input.pressEnter();
    }

    public void setBirthPlace(String text) {
        inputBirthPlace.click();
        SelenideElement ta = $x("//textarea[@ng-model='address']");
        ta.sendKeys(text);
        $x("//button[text()='OK']").click();
    }
}
