package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class FourthPage {
    private static final SelenideElement
            doneButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button"));

    @Step("Проверка отображения кнопки Get started на четвертой странице")
    public FourthPage visibilityCheckOfDoneButtonOnFourthPage() {
        doneButton.shouldBe(visible);
        return this;
    }
}
