package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public class ThirdPage {
    private static final SelenideElement
            continueButtonOnThirdPage = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            primaryText = $(id("org.wikipedia.alpha:id/primaryTextView")),
            skipButton = $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"));

    @Step("Проверка отображения текста Reading lists with sync на третьей странице")
    public ThirdPage checkPrimaryTextOnThirdPage() {
        primaryText.shouldHave(text("Reading lists with sync"));
        return this;
    }

    @Step("Нажатие на кнопку Continue на второй странице")
    public void clickOnContinueButtonOnThirdPage() {
        continueButtonOnThirdPage.click();
    }

    @Step("Проверка отображения кнопки Skip на третьей странице")
    public ThirdPage checkSkipButtonOnThirdPage() {
        skipButton.shouldBe(visible);
        skipButton.shouldHave(text("Skip"));
        return this;
    }
}
