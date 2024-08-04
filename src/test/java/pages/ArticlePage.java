package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.className;

public class ArticlePage {
    private final ElementsCollection
            contentArticle = $$(className("android.view.View"));

    @Step
    public ArticlePage findText(String value) {
        contentArticle.findBy(text(value));
        return this;
    }
}
