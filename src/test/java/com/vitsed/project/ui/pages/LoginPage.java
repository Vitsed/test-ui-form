package com.vitsed.project.ui.pages;

import com.codeborne.selenide.SelenideElement;
import com.vitsed.project.ui.entity.User;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends AbstractPage {

    SelenideElement loginField = $(byId("inputLogin"));
    SelenideElement passwordField = $(byId("inputPassword"));
    SelenideElement loginButton = $(byId("loginButton"));

    private void enterLogin(String text) {
        loginField.setValue(text);
    }

    private void enterPassword(String text) {
        passwordField.setValue(text);
    }

    private void pressEnterButton() {
        loginButton.click();
    }

    @Step("Ввести логин и пароль {user.name} / {user.password}.")
    public void loginWith(User user) {
        enterLogin(user.getName());
        enterPassword(user.getPassword());
        pressEnterButton();
        makeScreenshot();
    }
}