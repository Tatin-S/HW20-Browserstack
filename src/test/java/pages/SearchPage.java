package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class SearchPage {
    private static final SelenideElement
            searchBar = $(accessibilityId("Search Wikipedia")),
            searchText = $(id("org.wikipedia.alpha:id/search_src_text"));

    private final ElementsCollection
            listTitles = $$(id("org.wikipedia.alpha:id/page_list_item_title")),
            resultList = $$(id("org.wikipedia.alpha:id/page_list_item_description"));


    @Step("Проверяем отображение строки поиска")
    public SearchPage checkAccessibilityOfSearchBar() {
        searchBar.shouldBe(visible);
        return this;
    }

    @Step("Вводим значение в строку поиска")
    public SearchPage enterValueIntoSearch(String value) {
        searchBar.click();
        searchText.sendKeys(value);
        return this;
    }

    @Step("Проверяем отображение статей в результате поиска")
    public SearchPage checkListTitles() {
        listTitles.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Открываем первую статью в выпадающем списке")
    public SearchPage clickFirstArticleInResultList() {
        resultList.first().click();
        return this;
    }
}

