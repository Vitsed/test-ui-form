package com.vitsed.project.ui.pagewidgets;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class LoginForm {

    //Elements
    SelenideElement loginField = $(byId("inputLogin"));
    SelenideElement passwordField = $(byId("inputPassword"));
    SelenideElement loginButton = $(byId("loginButton"));

    //Actions
    public void enterLogin(String text) {
        loginField.setValue(text);
    }

    public void enterPassword(String text) {
        passwordField.setValue(text);
    }

    public void pressEnterButton() {
        loginButton.click();
    }
}
