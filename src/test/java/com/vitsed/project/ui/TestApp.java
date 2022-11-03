package com.vitsed.project.ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.vitsed.project.ui.pages.LoginForm;
import com.vitsed.project.ui.pages.MainPage;
import com.vitsed.project.ui.pages.PhysicalModal;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class TestApp {

    @BeforeAll
    static void allureReport() {
        SelenideLogger.addListener("AllureSelenide",
                                   new AllureSelenide()
                                           .screenshots(false)
                                           .savePageSource(true));

    }


    @Test
    public void loginFormTest() {
        // Arrange
        open("http://85.113.47.244:23480");
        // Act
        LoginForm loginPage = new LoginForm();
        loginPage.enterLogin("TEST");
        loginPage.enterPassword("Test1");
        loginPage.pressEnterButton();
        // Assert
        sleep(3000);
        webdriver().shouldHave(url("http://85.113.47.244:23480/index.html#/PersonsDataForm"));
    }

    @Test
    public void loginFormNegativeTest() {
        // Arrange
        open("http://85.113.47.244:23480");
        // Act
        LoginForm loginPage = new LoginForm();
        loginPage.enterLogin("TEST");
        loginPage.enterPassword("asdgasd");
        loginPage.pressEnterButton();

        // Assert
//        sleep(3000);
        Selenide.$(By.id("Password")).$(By.id("helpBlock"))
                .shouldBe(exist)
                .shouldHave(text("Неверный логин или пароль."),cssValue("color", "rgba(255, 0, 0, 1)"));
    }

    @Test
    public void inputDataToForm() {
        // Arrange
        open("http://85.113.47.244:23480");
        // Act
        LoginForm loginPage = new LoginForm();
        loginPage.enterLogin("TEST");
        loginPage.enterPassword("Test1");
        loginPage.pressEnterButton();

        MainPage mainPage = new MainPage();
        mainPage.pressAddBtn();
        mainPage.pressAddIndividualBtn();

        PhysicalModal physicalModal = new PhysicalModal();
        physicalModal.inputFirstName("Агузарова");
        physicalModal.inputLastName("Жана");
        physicalModal.inputPersonInn("500100732259");
        physicalModal.choosePersonSex("Ж");
        physicalModal.inputBirthday("18021990");
        physicalModal.choosePersonCitizenship("Республика Хорватия");
        physicalModal.setBirthPlace("г. Москва, Россия");
        sleep(3000);
        // Assert
//        sleep(3000);
    }
}
