package com.vitsed.project.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.vitsed.project.ui.entity.User;
import com.vitsed.project.ui.pages.LoginPage;
import com.vitsed.project.ui.pages.MainPage;
import com.vitsed.project.ui.pages.modal.AddressModal;
import com.vitsed.project.ui.pages.modal.PhysicalModal;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Calendar;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class TestApp {

    private final static Logger logger = LoggerFactory.getLogger(TestApp.class);

    @BeforeAll
    public static void setUp() {
        closeWebDriver();
        Configuration.baseUrl = "http://85.113.47.244:23480";
        SelenideLogger.addListener("AllureSelenide",
                                   new AllureSelenide()
                                           .screenshots(true)
                                           .savePageSource(false));
        logger.info("beforeAll");
    }

    @BeforeEach
    public void beforeEach() {
        showStartTime();
    }

    @Test
    @Description("Войти с правильным паролем")
    public void loginFormTest() throws Exception {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.loginWith(new User("TEST","Test1"));
        sleep(3000);
        webdriver().shouldHave(url("http://85.113.47.244:23480/index.html#/PersonsDataForm"));
    }

    @Test
    @Description("Зайти с неверным паролем")
    public void loginFormNegativeTest() throws Exception {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.loginWith(new User("TEST","asdgasdg"));

        Selenide.$(By.id("Password")).$(By.id("helpBlock"))
                .shouldBe(exist)
                .shouldHave(text("Неверный логин или пароль."),cssValue("color", "rgba(255, 0, 0, 1)"));
    }

    @Test
    @Description("Заполнить форму для физ.лица")
    public void inputDataToForm() throws Exception {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.loginWith(new User("TEST","Test1"));

        MainPage mainPage = new MainPage();
        mainPage.pressAddBtn();
        mainPage.pressAddIndividualBtn();

        PhysicalModal physicalModal = new PhysicalModal();
        physicalModal.inputFirstName("Агузарова");
        physicalModal.inputLastName("Жана");
        physicalModal.inputPersonInn("500100732259");
        physicalModal.choosePersonSex("Ж");
        physicalModal.inputBirthday("18.02.1990");
        physicalModal.choosePersonCitizenship("Республика Хорватия");
        physicalModal.setBirthPlace("г. Москва, Россия");
        physicalModal.enterRegistrationAddress();
        AddressModal addressModal = new AddressModal();
        addressModal.setZipcode("111000");
        addressModal.setRegions("МОСКВА");
        addressModal.pressButtonOk();
        physicalModal.pressButtonOk();
        sleep(3000);
    }

    @AfterEach
    public void tearDown() throws IOException {
        showEndTime();
    }

    @Attachment(value="start time", type="text/plain")
    public static String showStartTime() {
        return String.format("%tT", Calendar.getInstance().getTime());
    }

    @Attachment(value="end time", type="text/plain")
    public static String showEndTime() {
        return String.format("%tT", Calendar.getInstance().getTime());
    }
}
