package com.vitsed.project.ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;

import java.util.Base64;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public abstract class AbstractPage {

    SelenideElement buttonOk = $("div.modal-footer button:nth-child(2)");

    @Step("Нажать кнопку ок")
    public void pressButtonOk() {
        // русская раскладка
        buttonOk.shouldHave(text("ОК")).click();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        String screenshotAsBase64 = Selenide.screenshot(OutputType.BASE64);
        return Base64.getDecoder().decode(screenshotAsBase64);
    }
}
