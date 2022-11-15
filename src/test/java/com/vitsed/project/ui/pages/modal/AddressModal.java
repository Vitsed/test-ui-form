package com.vitsed.project.ui.pages.modal;

import com.codeborne.selenide.SelenideElement;
import com.vitsed.project.ui.pages.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AddressModal extends AbstractPage {

    SelenideElement zipcode = $("input[ng-model='address.index.index']");

    SelenideElement regions = $("*[list='regions']>div");

    SelenideElement loader = $("h4[ng-bind='caption']");

    @Step("Ввести индекс")
    public void setZipcode(String zip) {
        zipcode.sendKeys(zip);
        makeScreenshot();
    }

    public void setRegions(String reg) {
        regions.shouldBe(visible, Duration.ofSeconds(5)).click();
        regions.$("input").shouldBe(visible, Duration.ofSeconds(2)).sendKeys(reg + Keys.ENTER);
        makeScreenshot();
    }

}
