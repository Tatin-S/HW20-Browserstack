package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class FourthPage {
    private static final SelenideElement
            primaryText = $(id("org.wikipedia.alpha:id/primaryTextView")),
            doneButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button"));

    @Step("Проверка отображения кнопки Get started на четвертой странице")
    public FourthPage visibilityCheckOfDoneButtonOnFourthPage() {
        doneButton.shouldBe(visible);
        return this;
    }

    @Step("Проверка отображения текста Data & Privacy на четвертой странице")
    public FourthPage checkPrimaryTextOnFourthPage() {
        primaryText.shouldHave(text("Data & Privacy"));
        return this;
    }

    @Step("Нажатие на кнопку Get Started")
    public void clickToGetStarted() {
        doneButton.click();
    }
}
