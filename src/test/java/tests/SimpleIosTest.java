package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;

public class SimpleIosTest extends TestBase{
    @Test
    @Tag("ios")
    @DisplayName("Text enter test")
    void inputTextTest()  {
        step("Tap on Text button", () -> {
            $(accessibilityId("Text Button")).click();
        });
        step("Input text", () -> {
            $(accessibilityId("Text Input")).setValue("BrowserStack").pressEnter();
        });
        step("Verify that test output has the text from input", () -> {
            $(accessibilityId("Text Output")).shouldHave(text("BrowserStack"));
        });
    }
}