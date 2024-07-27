package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    @DisplayName("Find article by specific name test")
    void successfulSearchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () -> $$(id("page_list_item_title"))
                .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Open found article")
    void successfulOpenArticleTest() {
        step("Click Skip button", () -> {
            $(id("fragment_onboarding_skip_button")).click();
        });
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("search_src_text")).sendKeys("BrowserStack");
        });
        step("Open found article", () -> $(id("page_list_item_title")).click());
        step("Verify article", () -> {
            $(className("android.widget.TextView")).shouldHave(text("BrowserStack"));
        });
    }
}