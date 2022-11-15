package com.vitsed.project.ui.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;

import java.util.Base64;

public abstract class AbstractPage {

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        String screenshotAsBase64 = Selenide.screenshot(OutputType.BASE64);
        return Base64.getDecoder().decode(screenshotAsBase64);
    }
}
